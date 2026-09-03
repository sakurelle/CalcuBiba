package ru.calcubiba.calculator.gauss

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import java.math.BigInteger
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class GaussViewModel @Inject constructor(
    private val solveGaussSystemUseCase: SolveGaussSystemUseCase,
    private val calculationDispatcher: CoroutineDispatcher = Dispatchers.Default,
) : ViewModel() {
    private val _uiState = MutableStateFlow(GaussUiState())
    val uiState: StateFlow<GaussUiState> = _uiState.asStateFlow()

    fun onAction(action: GaussUiAction) {
        when (action) {
            is GaussUiAction.UpdateCoefficient -> updateCoefficient(action.row, action.column, action.value)
            is GaussUiAction.UpdateConstant -> updateConstant(action.row, action.value)
            is GaussUiAction.UpdateModulus -> _uiState.update { it.copy(modulus = action.value, error = null) }
            is GaussUiAction.UpdateRowCount -> resizeRows(action.value)
            is GaussUiAction.UpdateVariableCount -> resizeColumns(action.value)
            is GaussUiAction.SwitchInputMode -> _uiState.update { it.copy(inputMode = action.inputMode) }
            GaussUiAction.Calculate -> calculate()
            GaussUiAction.Clear -> _uiState.value = GaussUiState()
        }
    }

    private fun updateCoefficient(row: Int, column: Int, value: String) {
        _uiState.update { state ->
            val updatedCoefficients = state.coefficients.mapIndexed { rowIndex, cells ->
                if (rowIndex != row) {
                    cells
                } else {
                    cells.mapIndexed { columnIndex, currentValue ->
                        if (columnIndex == column) value else currentValue
                    }
                }
            }
            state.copy(
                coefficients = updatedCoefficients,
                error = null,
                result = null,
            )
        }
    }

    private fun updateConstant(row: Int, value: String) {
        _uiState.update { state ->
            state.copy(
                constants = state.constants.mapIndexed { index, currentValue ->
                    if (index == row) value else currentValue
                },
                error = null,
                result = null,
            )
        }
    }

    private fun resizeRows(rawValue: String) {
        val newRowCount = rawValue.toIntOrNull()?.coerceIn(1, 6) ?: return
        _uiState.update { state ->
            state.copy(
                rowCount = newRowCount,
                coefficients = resizeMatrix(state.coefficients, newRowCount, state.variableCount),
                constants = resizeVector(state.constants, newRowCount),
                error = null,
                result = null,
            )
        }
    }

    private fun resizeColumns(rawValue: String) {
        val newColumnCount = rawValue.toIntOrNull()?.coerceIn(1, 6) ?: return
        _uiState.update { state ->
            state.copy(
                variableCount = newColumnCount,
                coefficients = resizeMatrix(state.coefficients, state.rowCount, newColumnCount),
                error = null,
                result = null,
            )
        }
    }

    private fun calculate() {
        val currentState = _uiState.value
        if (currentState.isCalculating) {
            return
        }

        val modulus = currentState.modulus.trim().toBigIntegerOrNull()
        if (modulus == null || modulus <= BigInteger.ONE || !modulus.isProbablePrime(50)) {
            _uiState.update { it.copy(error = GaussError.INVALID_MODULUS) }
            return
        }

        if (currentState.coefficients.flatten().any { it.isBlank() } || currentState.constants.any { it.isBlank() }) {
            _uiState.update { it.copy(error = GaussError.EMPTY_CELL, result = null) }
            return
        }

        val coefficients = parseMatrix(currentState.coefficients)
        val constants = parseVector(currentState.constants)
        if (coefficients == null || constants == null) {
            _uiState.update { it.copy(error = GaussError.INVALID_NUMBER, result = null) }
            return
        }

        _uiState.update { it.copy(isCalculating = true, error = null) }
        viewModelScope.launch(calculationDispatcher) {
            runCatching {
                solveGaussSystemUseCase(
                    GaussSolveRequest(
                        modulus = modulus,
                        coefficients = coefficients,
                        constants = constants,
                    ),
                )
            }.onSuccess { solution ->
                _uiState.update {
                    it.copy(
                        isCalculating = false,
                        result = solution,
                        error = null,
                    )
                }
            }.onFailure {
                _uiState.update { state ->
                    state.copy(
                        isCalculating = false,
                        result = null,
                        error = GaussError.CALCULATION_FAILED,
                    )
                }
            }
        }
    }

    private fun parseMatrix(values: List<List<String>>): List<List<BigInteger>>? =
        values.map { row ->
            row.map { value ->
                value.trim().takeIf(String::isNotEmpty)?.toBigIntegerOrNull()
            }
        }.takeIf { matrix -> matrix.flatten().all { it != null } }
            ?.map { row -> row.mapNotNull { it } }

    private fun parseVector(values: List<String>): List<BigInteger>? =
        values.map { value ->
            value.trim().takeIf(String::isNotEmpty)?.toBigIntegerOrNull()
        }.takeIf { vector -> vector.all { it != null } }
            ?.mapNotNull { it }

    private fun resizeMatrix(
        current: List<List<String>>,
        newRowCount: Int,
        newColumnCount: Int,
    ): List<List<String>> =
        List(newRowCount) { row ->
            List(newColumnCount) { column ->
                current.getOrNull(row)?.getOrNull(column).orEmpty()
            }
        }

    private fun resizeVector(current: List<String>, newSize: Int): List<String> =
        List(newSize) { index -> current.getOrNull(index).orEmpty() }
}

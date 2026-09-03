package ru.calcubiba.calculator.gauss

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import java.math.BigInteger
import ru.calcubiba.core.designsystem.CalculatorScaffold
import ru.calcubiba.core.designsystem.MatrixEditor
import ru.calcubiba.core.designsystem.MatrixTable
import ru.calcubiba.core.designsystem.ScreenSection
import ru.calcubiba.core.designsystem.SectionCard
import ru.calcubiba.core.math.GeneralSolution
import ru.calcubiba.core.math.LinearSystemSolution
import ru.calcubiba.core.math.RowOperation
import ru.calcubiba.core.math.SolutionType

@Composable
fun GaussScreen(
    state: GaussUiState,
    onAction: (GaussUiAction) -> Unit,
    onBack: () -> Unit,
) {
    CalculatorScaffold(
        title = stringResource(R.string.gauss_title),
        onBack = onBack,
    ) { paddingValues ->
        ScreenSection(paddingValues = paddingValues) {
            GaussConfigurationSection(state = state, onAction = onAction)
            GaussInputModeSelector(state = state, onAction = onAction)
            when (state.inputMode) {
                GaussInputMode.LINEAR_SYSTEM -> LinearSystemEditor(state = state, onAction = onAction)
                GaussInputMode.AUGMENTED_MATRIX -> AugmentedMatrixEditor(state = state, onAction = onAction)
            }
            GaussActions(state = state, onAction = onAction)
            GaussResultSection(state = state)
        }
    }
}

@Composable
fun GaussConfigurationSection(
    state: GaussUiState,
    onAction: (GaussUiAction) -> Unit,
) {
    SectionCard(title = stringResource(R.string.gauss_configuration_title)) {
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            OutlinedTextField(
                value = state.rowCount.toString(),
                onValueChange = { onAction(GaussUiAction.UpdateRowCount(it)) },
                modifier = Modifier.weight(1f),
                singleLine = true,
                label = { Text(text = stringResource(R.string.gauss_rows_label)) },
            )
            OutlinedTextField(
                value = state.variableCount.toString(),
                onValueChange = { onAction(GaussUiAction.UpdateVariableCount(it)) },
                modifier = Modifier.weight(1f),
                singleLine = true,
                label = { Text(text = stringResource(R.string.gauss_variables_label)) },
            )
            OutlinedTextField(
                value = state.modulus,
                onValueChange = { onAction(GaussUiAction.UpdateModulus(it)) },
                modifier = Modifier.weight(1f),
                singleLine = true,
                label = { Text(text = stringResource(R.string.gauss_modulus_label)) },
            )
        }
    }
}

@Composable
fun GaussInputModeSelector(
    state: GaussUiState,
    onAction: (GaussUiAction) -> Unit,
) {
    SectionCard(title = stringResource(R.string.gauss_mode_title)) {
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            FilterChip(
                selected = state.inputMode == GaussInputMode.LINEAR_SYSTEM,
                onClick = { onAction(GaussUiAction.SwitchInputMode(GaussInputMode.LINEAR_SYSTEM)) },
                label = { Text(text = stringResource(R.string.gauss_mode_linear_system)) },
            )
            FilterChip(
                selected = state.inputMode == GaussInputMode.AUGMENTED_MATRIX,
                onClick = { onAction(GaussUiAction.SwitchInputMode(GaussInputMode.AUGMENTED_MATRIX)) },
                label = { Text(text = stringResource(R.string.gauss_mode_augmented)) },
            )
        }
    }
}

@Composable
fun LinearSystemEditor(
    state: GaussUiState,
    onAction: (GaussUiAction) -> Unit,
) {
    SectionCard(title = stringResource(R.string.gauss_linear_editor_title)) {
        Text(
            text = stringResource(R.string.gauss_linear_editor_hint),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        MatrixEditor(
            rowCount = state.rowCount,
            columnCount = state.variableCount,
            coefficientAt = { row, column -> state.coefficients[row][column] },
            onCoefficientChange = { row, column, value ->
                onAction(GaussUiAction.UpdateCoefficient(row, column, value))
            },
            constantAt = { row -> state.constants[row] },
            onConstantChange = { row, value ->
                onAction(GaussUiAction.UpdateConstant(row, value))
            },
        )
    }
}

@Composable
fun AugmentedMatrixEditor(
    state: GaussUiState,
    onAction: (GaussUiAction) -> Unit,
) {
    SectionCard(title = stringResource(R.string.gauss_augmented_editor_title)) {
        Text(
            text = stringResource(R.string.gauss_augmented_editor_hint),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        MatrixEditor(
            rowCount = state.rowCount,
            columnCount = state.variableCount,
            coefficientAt = { row, column -> state.coefficients[row][column] },
            onCoefficientChange = { row, column, value ->
                onAction(GaussUiAction.UpdateCoefficient(row, column, value))
            },
            constantAt = { row -> state.constants[row] },
            onConstantChange = { row, value ->
                onAction(GaussUiAction.UpdateConstant(row, value))
            },
        )
    }
}

@Composable
fun GaussActions(
    state: GaussUiState,
    onAction: (GaussUiAction) -> Unit,
) {
    SectionCard(title = stringResource(R.string.gauss_actions_title)) {
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            androidx.compose.material3.Button(
                onClick = { onAction(GaussUiAction.Calculate) },
                enabled = !state.isCalculating,
            ) {
                Text(text = stringResource(R.string.gauss_calculate_action))
            }
            androidx.compose.material3.OutlinedButton(
                onClick = { onAction(GaussUiAction.Clear) },
                enabled = !state.isCalculating,
            ) {
                Text(text = stringResource(R.string.gauss_clear_action))
            }
        }
    }
}

@Composable
fun GaussResultSection(state: GaussUiState) {
    SectionCard(title = stringResource(R.string.gauss_result_title)) {
        when {
            state.isCalculating -> CircularProgressIndicator()
            state.error != null -> Text(
                text = state.error.asText(),
                color = MaterialTheme.colorScheme.error,
            )
            state.result != null -> {
                Text(text = state.result.statusText())
                RrefMatrixCard(result = state.result)
                VariableClassificationCard(result = state.result)
                SolutionCard(result = state.result)
                RowOperationsCard(result = state.result)
            }
            else -> Text(
                text = stringResource(R.string.gauss_result_placeholder),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

@Composable
fun RrefMatrixCard(result: LinearSystemSolution<BigInteger>) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = stringResource(R.string.gauss_rref_title),
            style = MaterialTheme.typography.titleSmall,
        )
        MatrixTable(
            rows = result.reducedMatrix.rows().map { row -> row.map(BigInteger::toString) },
            pivotPositions = result.pivotColumns.mapIndexed { rowIndex, columnIndex ->
                rowIndex to columnIndex
            }.toSet(),
            inconsistentRows = result.inconsistentRows.toSet(),
            coefficientCount = result.reducedMatrix.columnCount - 1,
        )
    }
}

@Composable
fun VariableClassificationCard(result: LinearSystemSolution<BigInteger>) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = stringResource(R.string.gauss_variable_classification_title),
            style = MaterialTheme.typography.titleSmall,
        )
        Text(
            text = stringResource(
                R.string.gauss_basic_variables,
                result.pivotColumns.toVariableList(),
            ),
        )
        Text(
            text = stringResource(
                R.string.gauss_free_variables,
                result.freeColumns.toVariableList(),
            ),
        )
    }
}

@Composable
fun SolutionCard(result: LinearSystemSolution<BigInteger>) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = stringResource(R.string.gauss_solution_title),
            style = MaterialTheme.typography.titleSmall,
        )
        result.particularSolution?.let { particularSolution ->
            Text(
                text = stringResource(
                    R.string.gauss_particular_solution,
                    particularSolution.formatVector(),
                ),
            )
        }
        Text(
            text = stringResource(
                R.string.gauss_null_space_basis,
                if (result.nullSpaceBasis.isEmpty()) stringResource(R.string.gauss_none)
                else result.nullSpaceBasis.joinToString(separator = "; ") { it.formatVector() },
            ),
        )
        result.generalSolution?.let { generalSolution ->
            Text(
                text = stringResource(
                    R.string.gauss_general_solution,
                    generalSolution.asDisplayText(),
                ),
            )
        }
    }
}

@Composable
fun RowOperationsCard(result: LinearSystemSolution<BigInteger>) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = stringResource(R.string.gauss_row_operations_title),
            style = MaterialTheme.typography.titleSmall,
        )
        if (result.rowOperations.isEmpty()) {
            Text(text = stringResource(R.string.gauss_none))
        } else {
            result.rowOperations.forEach { operation ->
                Text(text = operation.asDisplayText())
            }
        }
    }
}

@Composable
private fun GaussError.asText(): String = when (this) {
    GaussError.INVALID_MODULUS -> stringResource(R.string.gauss_error_invalid_modulus)
    GaussError.EMPTY_CELL -> stringResource(R.string.gauss_error_empty_cell)
    GaussError.INVALID_NUMBER -> stringResource(R.string.gauss_error_invalid_number)
    GaussError.CALCULATION_FAILED -> stringResource(R.string.gauss_error_calculation_failed)
}

@Composable
private fun LinearSystemSolution<BigInteger>.statusText(): String = when (type) {
    SolutionType.UNIQUE -> stringResource(R.string.gauss_status_unique)
    SolutionType.INFINITE -> stringResource(R.string.gauss_status_infinite)
    SolutionType.INCONSISTENT -> stringResource(R.string.gauss_status_inconsistent)
}

private fun List<Int>.toVariableList(): String =
    if (isEmpty()) "-" else joinToString { "x${it + 1}" }

private fun List<BigInteger>.formatVector(): String =
    joinToString(prefix = "(", postfix = ")", separator = ", ") { it.toString() }

private fun GeneralSolution<BigInteger>.asDisplayText(): String {
    if (nullSpaceBasis.isEmpty()) {
        return particularSolution.formatVector()
    }

    val basisText = nullSpaceBasis.mapIndexed { index, vector ->
        "t${index + 1} * ${vector.formatVector()}"
    }.joinToString(separator = " + ")

    return "${particularSolution.formatVector()} + $basisText"
}

private fun RowOperation<BigInteger>.asDisplayText(): String = when (this) {
    is RowOperation.AddScaledRow ->
        "R${targetRow + 1} = R${targetRow + 1} + (${factor}) * R${sourceRow + 1}"
    is RowOperation.ScaleRow ->
        "R${row + 1} = (${factor}) * R${row + 1}"
    is RowOperation.SwapRows ->
        "R${firstRow + 1} <-> R${secondRow + 1}"
}

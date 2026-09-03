package ru.calcubiba.calculator.gauss

data class GaussUiState(
    val rowCount: Int = 2,
    val variableCount: Int = 2,
    val modulus: String = "0",
    val coefficients: List<List<String>> = emptyStringMatrix(rowCount = 2, columnCount = 2),
    val constants: List<String> = emptyStringVector(size = 2),
    val isCalculating: Boolean = false,
    val result: GaussSolveResult? = null,
    val error: GaussError? = null,
)

enum class GaussError {
    INVALID_MODULUS,
    EMPTY_CELL,
    INVALID_NUMBER,
    CALCULATION_FAILED,
}

internal fun emptyStringMatrix(rowCount: Int, columnCount: Int): List<List<String>> =
    List(rowCount) { List(columnCount) { "" } }

internal fun emptyStringVector(size: Int): List<String> = List(size) { "" }

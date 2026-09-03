package ru.calcubiba.core.math

data class AugmentedMatrix<E>(
    val coefficients: Matrix<E>,
    val constants: List<E>,
) {
    init {
        require(coefficients.rowCount == constants.size) {
            "Coefficient row count must match constants size."
        }
    }

    val rowCount: Int = coefficients.rowCount
    val variableCount: Int = coefficients.columnCount

    fun row(index: Int): List<E> = coefficients.row(index) + constants[index]

    fun rows(): List<List<E>> = List(rowCount, ::row)
}

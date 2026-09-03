package ru.calcubiba.core.math

data class GeneralSolution<E>(
    val particularSolution: List<E>,
    val nullSpaceBasis: List<List<E>>,
)

enum class SolutionType {
    UNIQUE,
    INFINITE,
    INCONSISTENT,
}

data class LinearSystemSolution<E>(
    val type: SolutionType,
    val reducedMatrix: Matrix<E>,
    val pivotColumns: List<Int>,
    val freeColumns: List<Int>,
    val particularSolution: List<E>?,
    val nullSpaceBasis: List<List<E>>,
    val generalSolution: GeneralSolution<E>?,
    val rowOperations: List<RowOperation<E>>,
    val inconsistentRows: List<Int>,
)

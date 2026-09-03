package ru.calcubiba.core.math

class GaussJordanSolver<E>(
    private val field: Field<E>,
) {
    fun solve(system: AugmentedMatrix<E>): LinearSystemSolution<E> {
        val matrix = system.rows().map { it.toMutableList() }.toMutableList()
        val pivotColumns = mutableListOf<Int>()
        val rowOperations = mutableListOf<RowOperation<E>>()

        var pivotRow = 0
        for (column in 0 until system.variableCount) {
            if (pivotRow >= system.rowCount) {
                break
            }

            val sourceRow = (pivotRow until system.rowCount)
                .firstOrNull { !field.isZero(matrix[it][column]) }
                ?: continue

            if (sourceRow != pivotRow) {
                matrix.swap(sourceRow, pivotRow)
                rowOperations += RowOperation.SwapRows(sourceRow, pivotRow)
            }

            val pivotValue = matrix[pivotRow][column]
            if (!isOne(pivotValue)) {
                val scaleFactor = field.inverse(pivotValue)
                scaleRow(matrix[pivotRow], scaleFactor)
                rowOperations += RowOperation.ScaleRow(pivotRow, scaleFactor)
            }

            for (row in matrix.indices) {
                if (row == pivotRow) {
                    continue
                }

                val factor = matrix[row][column]
                if (field.isZero(factor)) {
                    continue
                }

                val negatedFactor = field.negate(factor)
                addScaledRow(target = matrix[row], source = matrix[pivotRow], factor = negatedFactor)
                rowOperations += RowOperation.AddScaledRow(row, pivotRow, negatedFactor)
            }

            pivotColumns += column
            pivotRow += 1
        }

        val inconsistentRows = matrix.mapIndexedNotNull { rowIndex, row ->
            val leftPartIsZero = row.take(system.variableCount).all(field::isZero)
            val constantIsZero = field.isZero(row.last())
            rowIndex.takeIf { leftPartIsZero && !constantIsZero }
        }

        val reducedMatrix = Matrix.fromRows(matrix.map(List<E>::toList))

        if (inconsistentRows.isNotEmpty()) {
            return LinearSystemSolution(
                type = SolutionType.INCONSISTENT,
                reducedMatrix = reducedMatrix,
                pivotColumns = pivotColumns,
                freeColumns = (0 until system.variableCount).filterNot(pivotColumns::contains),
                particularSolution = null,
                nullSpaceBasis = emptyList(),
                generalSolution = null,
                rowOperations = rowOperations,
                inconsistentRows = inconsistentRows,
            )
        }

        val freeColumns = (0 until system.variableCount).filterNot(pivotColumns::contains)
        val particularSolution = MutableList(system.variableCount) { field.zero }

        pivotColumns.forEachIndexed { rowIndex, columnIndex ->
            particularSolution[columnIndex] = matrix[rowIndex].last()
        }

        val nullSpaceBasis = freeColumns.map { freeColumn ->
            MutableList(system.variableCount) { field.zero }.apply {
                this[freeColumn] = field.one
                pivotColumns.forEachIndexed { rowIndex, pivotColumn ->
                    this[pivotColumn] = field.negate(matrix[rowIndex][freeColumn])
                }
            }.toList()
        }

        val type = if (freeColumns.isEmpty()) SolutionType.UNIQUE else SolutionType.INFINITE
        val generalSolution = GeneralSolution(
            particularSolution = particularSolution.toList(),
            nullSpaceBasis = nullSpaceBasis,
        )

        return LinearSystemSolution(
            type = type,
            reducedMatrix = reducedMatrix,
            pivotColumns = pivotColumns,
            freeColumns = freeColumns,
            particularSolution = particularSolution.toList(),
            nullSpaceBasis = nullSpaceBasis,
            generalSolution = generalSolution,
            rowOperations = rowOperations,
            inconsistentRows = emptyList(),
        )
    }

    private fun scaleRow(row: MutableList<E>, factor: E) {
        row.indices.forEach { index ->
            row[index] = field.multiply(row[index], factor)
        }
    }

    private fun addScaledRow(
        target: MutableList<E>,
        source: List<E>,
        factor: E,
    ) {
        target.indices.forEach { index ->
            target[index] = field.add(target[index], field.multiply(source[index], factor))
        }
    }

    private fun isOne(value: E): Boolean = field.subtract(value, field.one).let(field::isZero)

    private fun MutableList<MutableList<E>>.swap(firstRow: Int, secondRow: Int) {
        val buffer = this[firstRow]
        this[firstRow] = this[secondRow]
        this[secondRow] = buffer
    }
}

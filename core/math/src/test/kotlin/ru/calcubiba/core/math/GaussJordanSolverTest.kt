package ru.calcubiba.core.math

import java.math.BigInteger
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

class GaussJordanSolverTest {
    private val gf5 = PrimeField(5.bi)
    private val solver = GaussJordanSolver(gf5)

    @Test
    fun `solves system with unique solution over gf5`() {
        val solution = solver.solve(
            systemOf(
                coefficients = listOf(
                    listOf(1, 1),
                    listOf(1, 2),
                ),
                constants = listOf(1, 3),
            ),
        )

        assertEquals(SolutionType.UNIQUE, solution.type)
        assertEquals(listOf(4.bi, 2.bi), solution.particularSolution)
        assertTrue(solution.freeColumns.isEmpty())
    }

    @Test
    fun `detects infinite solution space`() {
        val solution = solver.solve(
            systemOf(
                coefficients = listOf(
                    listOf(1, 1),
                    listOf(2, 2),
                ),
                constants = listOf(1, 2),
            ),
        )

        assertEquals(SolutionType.INFINITE, solution.type)
        assertEquals(listOf(1.bi, 0.bi), solution.particularSolution)
        assertEquals(listOf(listOf(4.bi, 1.bi)), solution.nullSpaceBasis)
    }

    @Test
    fun `detects inconsistent system`() {
        val solution = solver.solve(
            systemOf(
                coefficients = listOf(
                    listOf(1, 1),
                    listOf(1, 1),
                ),
                constants = listOf(1, 2),
            ),
        )

        assertEquals(SolutionType.INCONSISTENT, solution.type)
        assertTrue(solution.inconsistentRows.isNotEmpty())
    }

    @Test
    fun `swaps rows when pivot candidate is zero`() {
        val solution = solver.solve(
            systemOf(
                coefficients = listOf(
                    listOf(0, 1),
                    listOf(1, 1),
                ),
                constants = listOf(1, 2),
            ),
        )

        assertTrue(solution.rowOperations.any { it is RowOperation.SwapRows })
        assertEquals(listOf(1.bi, 1.bi), solution.particularSolution)
    }

    @Test
    fun `supports free first column`() {
        val solution = solver.solve(
            systemOf(
                coefficients = listOf(
                    listOf(0, 1, 0),
                    listOf(0, 0, 1),
                ),
                constants = listOf(1, 2),
            ),
        )

        assertEquals(listOf(0), solution.freeColumns)
    }

    @Test
    fun `supports more rows than variables`() {
        val solution = solver.solve(
            systemOf(
                coefficients = listOf(
                    listOf(1, 0),
                    listOf(0, 1),
                    listOf(1, 1),
                ),
                constants = listOf(1, 2, 3),
            ),
        )

        assertEquals(SolutionType.UNIQUE, solution.type)
        assertEquals(listOf(1.bi, 2.bi), solution.particularSolution)
    }

    @Test
    fun `supports more variables than rows`() {
        val solution = solver.solve(
            systemOf(
                coefficients = listOf(
                    listOf(1, 0, 1),
                    listOf(0, 1, 1),
                ),
                constants = listOf(1, 2),
            ),
        )

        assertEquals(SolutionType.INFINITE, solution.type)
        assertEquals(listOf(2), solution.freeColumns)
    }

    @Test
    fun `handles zero row`() {
        val solution = solver.solve(
            systemOf(
                coefficients = listOf(
                    listOf(1, 0),
                    listOf(0, 0),
                ),
                constants = listOf(1, 0),
            ),
        )

        assertEquals(SolutionType.INFINITE, solution.type)
        assertEquals(listOf(1), solution.freeColumns)
    }

    @Test
    fun `normalizes negative input coefficients`() {
        val solution = solver.solve(
            systemOf(
                coefficients = listOf(
                    listOf(-1, 1),
                    listOf(0, 1),
                ),
                constants = listOf(0, 2),
            ),
        )

        assertEquals(listOf(2.bi, 2.bi), solution.particularSolution)
    }

    @Test
    fun `normalizes coefficients larger than modulus`() {
        val solution = solver.solve(
            systemOf(
                coefficients = listOf(
                    listOf(6, 0),
                    listOf(0, 12),
                ),
                constants = listOf(6, 9),
            ),
        )

        assertEquals(listOf(1.bi, 2.bi), solution.particularSolution)
    }

    @Test
    fun `solves over gf2`() {
        val gf2 = PrimeField(2.bi)
        val solution = GaussJordanSolver(gf2).solve(
            AugmentedMatrix(
                coefficients = Matrix.fromRows(
                    listOf(
                        listOf(1.bi, 1.bi),
                        listOf(0.bi, 1.bi),
                    ),
                ),
                constants = listOf(0.bi, 1.bi),
            ),
        )

        assertEquals(listOf(1.bi, 1.bi), solution.particularSolution)
    }

    @Test
    fun `does not mutate original matrix`() {
        val coefficients = Matrix.fromRows(
            listOf(
                listOf(1.bi, 1.bi),
                listOf(1.bi, 2.bi),
            ),
        )
        val constants = listOf(1.bi, 3.bi)

        solver.solve(AugmentedMatrix(coefficients, constants))

        assertEquals(1.bi, coefficients[0, 0])
        assertEquals(2.bi, coefficients[1, 1])
        assertEquals(listOf(1.bi, 1.bi), coefficients.row(0))
        assertEquals(listOf(1.bi, 2.bi), coefficients.row(1))
    }

    private fun systemOf(
        coefficients: List<List<Int>>,
        constants: List<Int>,
    ): AugmentedMatrix<BigInteger> = AugmentedMatrix(
        coefficients = Matrix.fromRows(
            coefficients.map { row -> row.map { value -> gf5.normalize(value.bi) } },
        ),
        constants = constants.map { value -> gf5.normalize(value.bi) },
    )
}

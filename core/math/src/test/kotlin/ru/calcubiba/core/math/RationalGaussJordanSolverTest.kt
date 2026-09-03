package ru.calcubiba.core.math

import org.junit.Assert.assertEquals
import org.junit.Test

class RationalGaussJordanSolverTest {
    private val solver = GaussJordanSolver(RationalField)

    @Test
    fun `solves system with fractional unique solution`() {
        val solution = solve(
            coefficients = listOf(listOf(1, 1), listOf(1, -1)),
            constants = listOf(1, 0),
        )

        assertEquals(SolutionType.UNIQUE, solution.type)
        assertEquals(listOf(Rational(1.bi, 2.bi), Rational(1.bi, 2.bi)), solution.particularSolution)
    }

    @Test
    fun `solves system with negative coefficients without rounding`() {
        val solution = solve(
            coefficients = listOf(listOf(2, 1), listOf(1, -1)),
            constants = listOf(5, 1),
        )

        assertEquals(listOf(Rational(2.bi), Rational.ONE), solution.particularSolution)
    }

    @Test
    fun `detects infinite and inconsistent systems`() {
        val infinite = solve(
            coefficients = listOf(listOf(1, 1), listOf(2, 2)),
            constants = listOf(1, 2),
        )
        val inconsistent = solve(
            coefficients = listOf(listOf(1, 1), listOf(1, 1)),
            constants = listOf(1, 2),
        )

        assertEquals(SolutionType.INFINITE, infinite.type)
        assertEquals(SolutionType.INCONSISTENT, inconsistent.type)
    }

    private fun solve(
        coefficients: List<List<Int>>,
        constants: List<Int>,
    ): LinearSystemSolution<Rational> = solver.solve(
        AugmentedMatrix(
            coefficients = Matrix.fromRows(coefficients.map { row -> row.map { Rational(it.bi) } }),
            constants = constants.map { Rational(it.bi) },
        ),
    )
}

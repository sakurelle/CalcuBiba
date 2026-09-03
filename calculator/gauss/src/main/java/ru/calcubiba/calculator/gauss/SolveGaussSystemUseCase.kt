package ru.calcubiba.calculator.gauss

import java.math.BigInteger
import javax.inject.Inject
import ru.calcubiba.core.math.AugmentedMatrix
import ru.calcubiba.core.math.GaussJordanSolver
import ru.calcubiba.core.math.LinearSystemSolution
import ru.calcubiba.core.math.Matrix
import ru.calcubiba.core.math.PrimeField

data class GaussSolveRequest(
    val modulus: BigInteger,
    val coefficients: List<List<BigInteger>>,
    val constants: List<BigInteger>,
)

fun interface SolveGaussSystemUseCase {
    suspend operator fun invoke(request: GaussSolveRequest): LinearSystemSolution<BigInteger>
}

class DefaultSolveGaussSystemUseCase @Inject constructor() : SolveGaussSystemUseCase {
    override suspend fun invoke(request: GaussSolveRequest): LinearSystemSolution<BigInteger> {
        val field = PrimeField(request.modulus)
        val normalizedCoefficients = request.coefficients.map { row ->
            row.map(field::normalize)
        }
        val normalizedConstants = request.constants.map(field::normalize)

        return GaussJordanSolver(field).solve(
            AugmentedMatrix(
                coefficients = Matrix.fromRows(normalizedCoefficients),
                constants = normalizedConstants,
            ),
        )
    }
}

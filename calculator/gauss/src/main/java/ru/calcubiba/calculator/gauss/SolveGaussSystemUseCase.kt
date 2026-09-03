package ru.calcubiba.calculator.gauss

import java.math.BigInteger
import javax.inject.Inject
import ru.calcubiba.core.math.AugmentedMatrix
import ru.calcubiba.core.math.GaussJordanSolver
import ru.calcubiba.core.math.GeneralSolution
import ru.calcubiba.core.math.LinearSystemSolution
import ru.calcubiba.core.math.Matrix
import ru.calcubiba.core.math.PrimeField
import ru.calcubiba.core.math.Rational
import ru.calcubiba.core.math.RationalField
import ru.calcubiba.core.math.RowOperation
import ru.calcubiba.core.math.SolutionType

data class GaussSolveRequest(
    val modulus: BigInteger,
    val coefficients: List<List<String>>,
    val constants: List<String>,
)

data class GaussSolveResult(
    val type: SolutionType,
    val reducedMatrix: List<List<String>>,
    val pivotColumns: List<Int>,
    val freeColumns: List<Int>,
    val particularSolution: List<String>?,
    val nullSpaceBasis: List<List<String>>,
    val generalSolution: GaussGeneralSolution?,
    val rowOperations: List<GaussRowOperation>,
    val inconsistentRows: List<Int>,
)

data class GaussGeneralSolution(
    val particularSolution: List<String>,
    val nullSpaceBasis: List<List<String>>,
)

sealed interface GaussRowOperation {
    data class SwapRows(val firstRow: Int, val secondRow: Int) : GaussRowOperation
    data class ScaleRow(val row: Int, val factor: String) : GaussRowOperation
    data class AddScaledRow(val targetRow: Int, val sourceRow: Int, val factor: String) : GaussRowOperation
}

fun interface SolveGaussSystemUseCase {
    suspend operator fun invoke(request: GaussSolveRequest): GaussSolveResult
}

class DefaultSolveGaussSystemUseCase @Inject constructor() : SolveGaussSystemUseCase {
    override suspend fun invoke(request: GaussSolveRequest): GaussSolveResult = when {
        request.modulus == BigInteger.ZERO -> solveOverRationals(request)
        request.modulus > BigInteger.ONE && request.modulus.isProbablePrime(PRIMALITY_CERTAINTY) ->
            solveOverPrimeField(request)
        else -> throw IllegalArgumentException("Modulus must be zero or a prime number greater than 1.")
    }

    private fun solveOverRationals(request: GaussSolveRequest): GaussSolveResult {
        val coefficients = request.coefficients.map { row -> row.map(::parseRational) }
        val constants = request.constants.map(::parseRational)
        return GaussJordanSolver(RationalField).solve(
            AugmentedMatrix(Matrix.fromRows(coefficients), constants),
        ).toPresentation(Rational::toString)
    }

    private fun solveOverPrimeField(request: GaussSolveRequest): GaussSolveResult {
        val field = PrimeField(request.modulus)
        val coefficients = request.coefficients.map { row ->
            row.map { value -> field.normalize(parseInteger(value)) }
        }
        val constants = request.constants.map { value -> field.normalize(parseInteger(value)) }
        return GaussJordanSolver(field).solve(
            AugmentedMatrix(
                coefficients = Matrix.fromRows(coefficients),
                constants = constants,
            ),
        ).toPresentation(BigInteger::toString)
    }

    private fun parseRational(value: String): Rational =
        Rational.parse(value) ?: throw IllegalArgumentException("Invalid rational number.")

    private fun parseInteger(value: String): BigInteger =
        value.trim().toBigIntegerOrNull() ?: throw IllegalArgumentException("Invalid integer.")

    private fun <E> LinearSystemSolution<E>.toPresentation(render: (E) -> String): GaussSolveResult =
        GaussSolveResult(
            type = type,
            reducedMatrix = reducedMatrix.rows().map { row -> row.map(render) },
            pivotColumns = pivotColumns,
            freeColumns = freeColumns,
            particularSolution = particularSolution?.map(render),
            nullSpaceBasis = nullSpaceBasis.map { vector -> vector.map(render) },
            generalSolution = generalSolution?.toPresentation(render),
            rowOperations = rowOperations.map { operation -> operation.toPresentation(render) },
            inconsistentRows = inconsistentRows,
        )

    private fun <E> GeneralSolution<E>.toPresentation(render: (E) -> String): GaussGeneralSolution =
        GaussGeneralSolution(
            particularSolution = particularSolution.map(render),
            nullSpaceBasis = nullSpaceBasis.map { vector -> vector.map(render) },
        )

    private fun <E> RowOperation<E>.toPresentation(render: (E) -> String): GaussRowOperation = when (this) {
        is RowOperation.SwapRows -> GaussRowOperation.SwapRows(firstRow, secondRow)
        is RowOperation.ScaleRow -> GaussRowOperation.ScaleRow(row, render(factor))
        is RowOperation.AddScaledRow -> GaussRowOperation.AddScaledRow(targetRow, sourceRow, render(factor))
    }

    private companion object {
        const val PRIMALITY_CERTAINTY = 50
    }
}

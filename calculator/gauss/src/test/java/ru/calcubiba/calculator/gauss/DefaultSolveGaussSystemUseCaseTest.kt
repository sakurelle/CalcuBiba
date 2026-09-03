package ru.calcubiba.calculator.gauss

import java.math.BigInteger
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import ru.calcubiba.core.math.SolutionType

class DefaultSolveGaussSystemUseCaseTest {
    private val useCase = DefaultSolveGaussSystemUseCase()

    @Test
    fun `solves exact rational system when modulus is zero`() = runTest {
        val result = useCase(
            request(
                modulus = 0,
                coefficients = listOf(listOf("1", "1"), listOf("1", "-1")),
                constants = listOf("1", "0"),
            ),
        )

        assertEquals(SolutionType.UNIQUE, result.type)
        assertEquals(listOf("1/2", "1/2"), result.particularSolution)
        assertEquals(listOf(listOf("1", "0", "1/2"), listOf("0", "1", "1/2")), result.reducedMatrix)
    }

    @Test
    fun `keeps prime field normalization`() = runTest {
        val result = useCase(
            request(
                modulus = 5,
                coefficients = listOf(listOf("-1", "1"), listOf("0", "1")),
                constants = listOf("0", "2"),
            ),
        )

        assertEquals(listOf("2", "2"), result.particularSolution)
    }

    @Test
    fun `rejects one negative and composite moduli`() {
        listOf(1, -1, 9).forEach { modulus ->
            assertThrows(IllegalArgumentException::class.java) {
                runBlocking { useCase(request(modulus)) }
            }
        }
    }

    private fun request(
        modulus: Int,
        coefficients: List<List<String>> = listOf(listOf("1")),
        constants: List<String> = listOf("1"),
    ): GaussSolveRequest = GaussSolveRequest(
        modulus = BigInteger.valueOf(modulus.toLong()),
        coefficients = coefficients,
        constants = constants,
    )
}

package ru.calcubiba.calculator.gauss

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Rule
import org.junit.Test
import ru.calcubiba.core.math.SolutionType

@OptIn(ExperimentalCoroutinesApi::class)
class GaussViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun `changing size preserves overlapping cells`() {
        val viewModel = GaussViewModel(FakeSolveGaussSystemUseCase(), mainDispatcherRule.dispatcher)
        viewModel.onAction(GaussUiAction.UpdateCoefficient(0, 0, "7"))
        viewModel.onAction(GaussUiAction.UpdateCoefficient(1, 1, "9"))

        viewModel.onAction(GaussUiAction.UpdateRowCount("3"))
        viewModel.onAction(GaussUiAction.UpdateVariableCount("3"))

        val state = viewModel.uiState.value
        assertEquals("7", state.coefficients[0][0])
        assertEquals("9", state.coefficients[1][1])
        assertEquals("", state.coefficients[2][2])
    }

    @Test
    fun `calculate with composite modulus does not invoke use case`() = runTest {
        val fakeUseCase = FakeSolveGaussSystemUseCase()
        val viewModel = GaussViewModel(fakeUseCase, mainDispatcherRule.dispatcher)
        populateRequiredFields(viewModel)
        viewModel.onAction(GaussUiAction.UpdateModulus("9"))

        viewModel.onAction(GaussUiAction.Calculate)
        advanceUntilIdle()

        assertEquals(0, fakeUseCase.invocationCount)
        assertEquals(GaussError.INVALID_MODULUS, viewModel.uiState.value.error)
    }

    @Test
    fun `calculate accepts zero modulus and fractional coefficients`() = runTest {
        val fakeUseCase = FakeSolveGaussSystemUseCase()
        val viewModel = GaussViewModel(fakeUseCase, mainDispatcherRule.dispatcher)
        populateRequiredFields(viewModel)
        viewModel.onAction(GaussUiAction.UpdateModulus("0"))
        viewModel.onAction(GaussUiAction.UpdateCoefficient(0, 0, "1/2"))

        viewModel.onAction(GaussUiAction.Calculate)
        advanceUntilIdle()

        assertEquals(1, fakeUseCase.invocationCount)
        assertNull(viewModel.uiState.value.error)
    }

    @Test
    fun `calculate rejects one and negative modulus`() {
        val viewModel = GaussViewModel(FakeSolveGaussSystemUseCase(), mainDispatcherRule.dispatcher)
        populateRequiredFields(viewModel)

        viewModel.onAction(GaussUiAction.UpdateModulus("1"))
        viewModel.onAction(GaussUiAction.Calculate)
        assertEquals(GaussError.INVALID_MODULUS, viewModel.uiState.value.error)

        viewModel.onAction(GaussUiAction.UpdateModulus("-5"))
        viewModel.onAction(GaussUiAction.Calculate)
        assertEquals(GaussError.INVALID_MODULUS, viewModel.uiState.value.error)
    }

    @Test
    fun `successful calculation updates result`() = runTest {
        val expectedResult = sampleResult()
        val fakeUseCase = FakeSolveGaussSystemUseCase(expectedResult)
        val viewModel = GaussViewModel(fakeUseCase, mainDispatcherRule.dispatcher)
        populateRequiredFields(viewModel)

        viewModel.onAction(GaussUiAction.Calculate)
        advanceUntilIdle()

        assertEquals(expectedResult, viewModel.uiState.value.result)
        assertNull(viewModel.uiState.value.error)
    }

    @Test
    fun `clear resets data`() {
        val viewModel = GaussViewModel(FakeSolveGaussSystemUseCase(), mainDispatcherRule.dispatcher)
        populateRequiredFields(viewModel)
        viewModel.onAction(GaussUiAction.UpdateModulus("11"))

        viewModel.onAction(GaussUiAction.Clear)

        val state = viewModel.uiState.value
        assertEquals("0", state.modulus)
        assertEquals(2, state.rowCount)
        assertEquals(2, state.variableCount)
        assertEquals(listOf(listOf("", ""), listOf("", "")), state.coefficients)
        assertEquals(listOf("", ""), state.constants)
        assertNull(state.result)
    }

    private fun populateRequiredFields(viewModel: GaussViewModel) {
        viewModel.onAction(GaussUiAction.UpdateCoefficient(0, 0, "1"))
        viewModel.onAction(GaussUiAction.UpdateCoefficient(0, 1, "2"))
        viewModel.onAction(GaussUiAction.UpdateCoefficient(1, 0, "3"))
        viewModel.onAction(GaussUiAction.UpdateCoefficient(1, 1, "4"))
        viewModel.onAction(GaussUiAction.UpdateConstant(0, "2"))
        viewModel.onAction(GaussUiAction.UpdateConstant(1, "4"))
    }

    private fun sampleResult(): GaussSolveResult = GaussSolveResult(
        type = SolutionType.UNIQUE,
        reducedMatrix = listOf(listOf("1", "0", "2"), listOf("0", "1", "4")),
        pivotColumns = listOf(0, 1),
        freeColumns = emptyList(),
        particularSolution = listOf("2", "4"),
        nullSpaceBasis = emptyList(),
        generalSolution = GaussGeneralSolution(
            particularSolution = listOf("2", "4"),
            nullSpaceBasis = emptyList(),
        ),
        rowOperations = emptyList(),
        inconsistentRows = emptyList(),
    )
}

private class FakeSolveGaussSystemUseCase(
    private val result: GaussSolveResult = GaussSolveResult(
        type = SolutionType.UNIQUE,
        reducedMatrix = listOf(listOf("1", "0", "1"), listOf("0", "1", "1")),
        pivotColumns = listOf(0, 1),
        freeColumns = emptyList(),
        particularSolution = listOf("1", "1"),
        nullSpaceBasis = emptyList(),
        generalSolution = GaussGeneralSolution(
            particularSolution = listOf("1", "1"),
            nullSpaceBasis = emptyList(),
        ),
        rowOperations = emptyList(),
        inconsistentRows = emptyList(),
    ),
) : SolveGaussSystemUseCase {
    var invocationCount: Int = 0
        private set

    override suspend fun invoke(request: GaussSolveRequest): GaussSolveResult {
        invocationCount += 1
        return result
    }
}

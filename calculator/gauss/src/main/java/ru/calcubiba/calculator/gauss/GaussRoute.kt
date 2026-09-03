package ru.calcubiba.calculator.gauss

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun GaussRoute(
    onBack: () -> Unit,
    viewModel: GaussViewModel = hiltViewModel(),
) {
    val state = viewModel.uiState.collectAsStateWithLifecycle()
    GaussScreen(
        state = state.value,
        onAction = viewModel::onAction,
        onBack = onBack,
    )
}

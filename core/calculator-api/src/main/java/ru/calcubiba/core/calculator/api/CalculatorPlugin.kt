package ru.calcubiba.core.calculator.api

import androidx.compose.runtime.Composable

interface CalculatorPlugin {
    val descriptor: CalculatorDescriptor

    @Composable
    fun EntryPoint(
        onBack: () -> Unit,
    )
}

package ru.calcubiba.core.calculator.api

data class CalculatorDescriptor(
    val id: String,
    val title: String,
    val shortDescription: String,
    val category: CalculatorCategory,
    val iconKey: CalculatorIconKey,
    val order: Int,
)

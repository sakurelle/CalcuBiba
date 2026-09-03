package ru.calcubiba.calculator.gauss

sealed interface GaussUiAction {
    data class UpdateModulus(val value: String) : GaussUiAction
    data class UpdateRowCount(val value: String) : GaussUiAction
    data class UpdateVariableCount(val value: String) : GaussUiAction
    data class UpdateCoefficient(val row: Int, val column: Int, val value: String) : GaussUiAction
    data class UpdateConstant(val row: Int, val value: String) : GaussUiAction
    data object Calculate : GaussUiAction
    data object Clear : GaussUiAction
}

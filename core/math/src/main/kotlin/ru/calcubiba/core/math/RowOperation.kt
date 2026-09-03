package ru.calcubiba.core.math

sealed interface RowOperation<E> {
    data class SwapRows<E>(
        val firstRow: Int,
        val secondRow: Int,
    ) : RowOperation<E>

    data class ScaleRow<E>(
        val row: Int,
        val factor: E,
    ) : RowOperation<E>

    data class AddScaledRow<E>(
        val targetRow: Int,
        val sourceRow: Int,
        val factor: E,
    ) : RowOperation<E>
}

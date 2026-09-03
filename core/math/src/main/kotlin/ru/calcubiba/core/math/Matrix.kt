package ru.calcubiba.core.math

class Matrix<E> private constructor(
    private val content: List<List<E>>,
) {
    val rowCount: Int = content.size
    val columnCount: Int = content.firstOrNull()?.size ?: 0

    operator fun get(row: Int, column: Int): E = content[row][column]

    fun row(index: Int): List<E> = content[index]

    fun rows(): List<List<E>> = content.map(List<E>::toList)

    companion object {
        fun <E> fromRows(rows: List<List<E>>): Matrix<E> {
            require(rows.isNotEmpty()) { "Matrix must have at least one row." }
            val columnCount = rows.first().size
            require(columnCount > 0) { "Matrix must have at least one column." }
            require(rows.all { it.size == columnCount }) { "Matrix rows must have equal size." }
            return Matrix(rows.map(List<E>::toList))
        }
    }
}

package ru.calcubiba.core.math

interface Field<E> {
    val zero: E
    val one: E

    fun add(left: E, right: E): E
    fun subtract(left: E, right: E): E
    fun multiply(left: E, right: E): E
    fun inverse(value: E): E
    fun divide(left: E, right: E): E = multiply(left, inverse(right))
    fun negate(value: E): E = subtract(zero, value)
    fun isZero(value: E): Boolean
}

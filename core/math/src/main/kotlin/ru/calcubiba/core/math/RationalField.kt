package ru.calcubiba.core.math

object RationalField : Field<Rational> {
    override val zero: Rational = Rational.ZERO
    override val one: Rational = Rational.ONE

    override fun add(left: Rational, right: Rational): Rational = left + right

    override fun subtract(left: Rational, right: Rational): Rational = left - right

    override fun multiply(left: Rational, right: Rational): Rational = left * right

    override fun inverse(value: Rational): Rational = value.inverse()

    override fun divide(left: Rational, right: Rational): Rational = left / right

    override fun negate(value: Rational): Rational = -value

    override fun isZero(value: Rational): Boolean = value.isZero()
}

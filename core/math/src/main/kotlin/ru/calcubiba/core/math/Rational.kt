package ru.calcubiba.core.math

import java.math.BigInteger

class Rational private constructor(
    val numerator: BigInteger,
    val denominator: BigInteger,
) {
    operator fun plus(other: Rational): Rational = of(
        numerator * other.denominator + other.numerator * denominator,
        denominator * other.denominator,
    )

    operator fun minus(other: Rational): Rational = of(
        numerator * other.denominator - other.numerator * denominator,
        denominator * other.denominator,
    )

    operator fun times(other: Rational): Rational = of(
        numerator * other.numerator,
        denominator * other.denominator,
    )

    operator fun div(other: Rational): Rational = this * other.inverse()

    operator fun unaryMinus(): Rational = of(numerator.negate(), denominator)

    fun inverse(): Rational {
        require(!isZero()) { "Zero does not have a multiplicative inverse." }
        return of(denominator, numerator)
    }

    fun isZero(): Boolean = numerator == BigInteger.ZERO

    override fun toString(): String =
        if (denominator == BigInteger.ONE) numerator.toString() else "$numerator/$denominator"

    override fun equals(other: Any?): Boolean =
        other is Rational && numerator == other.numerator && denominator == other.denominator

    override fun hashCode(): Int = 31 * numerator.hashCode() + denominator.hashCode()

    companion object {
        val ZERO: Rational = Rational(BigInteger.ZERO, BigInteger.ONE)
        val ONE: Rational = Rational(BigInteger.ONE, BigInteger.ONE)

        operator fun invoke(numerator: BigInteger, denominator: BigInteger = BigInteger.ONE): Rational =
            of(numerator, denominator)

        fun of(numerator: BigInteger, denominator: BigInteger = BigInteger.ONE): Rational {
            require(denominator != BigInteger.ZERO) { "Rational denominator must not be zero." }
            if (numerator == BigInteger.ZERO) return ZERO

            val sign = if (denominator.signum() < 0) BigInteger.ONE.negate() else BigInteger.ONE
            val divisor = numerator.gcd(denominator)
            return Rational(
                numerator = numerator.divide(divisor) * sign,
                denominator = denominator.divide(divisor) * sign,
            )
        }

        fun parse(value: String): Rational? {
            val parts = value.split('/')
            if (parts.size !in 1..2) return null
            val numerator = parts[0].trim().toBigIntegerOrNull() ?: return null
            val denominator = if (parts.size == 2) {
                parts[1].trim().toBigIntegerOrNull() ?: return null
            } else {
                BigInteger.ONE
            }
            return runCatching { of(numerator, denominator) }.getOrNull()
        }
    }
}

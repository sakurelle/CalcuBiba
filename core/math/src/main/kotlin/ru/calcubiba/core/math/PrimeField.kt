package ru.calcubiba.core.math

import java.math.BigInteger

class PrimeField(
    val modulus: BigInteger,
) : Field<BigInteger> {
    init {
        require(modulus > BigInteger.ONE) { "Modulus must be greater than 1." }
        require(modulus.isProbablePrime(PRIMALITY_CERTAINTY)) { "Modulus must be prime." }
    }

    override val zero: BigInteger = BigInteger.ZERO
    override val one: BigInteger = BigInteger.ONE

    fun normalize(value: BigInteger): BigInteger {
        return value.mod(modulus)
    }

    override fun add(left: BigInteger, right: BigInteger): BigInteger = normalize(left + right)

    override fun subtract(left: BigInteger, right: BigInteger): BigInteger = normalize(left - right)

    override fun multiply(left: BigInteger, right: BigInteger): BigInteger = normalize(left * right)

    override fun inverse(value: BigInteger): BigInteger {
        val normalized = normalize(value)
        require(!isZero(normalized)) { "Zero does not have a multiplicative inverse in GF(p)." }
        return normalized.modInverse(modulus)
    }

    override fun divide(left: BigInteger, right: BigInteger): BigInteger =
        multiply(left, inverse(right))

    override fun negate(value: BigInteger): BigInteger = normalize(value.negate())

    override fun isZero(value: BigInteger): Boolean = normalize(value) == zero

    companion object {
        private const val PRIMALITY_CERTAINTY = 50
    }
}

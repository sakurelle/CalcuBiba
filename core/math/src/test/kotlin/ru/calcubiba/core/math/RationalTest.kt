package ru.calcubiba.core.math

import java.math.BigInteger
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class RationalTest {
    @Test
    fun `reduces fraction`() {
        assertEquals(Rational(1.bi, 2.bi), Rational(2.bi, 4.bi))
    }

    @Test
    fun `normalizes denominator sign`() {
        assertEquals(Rational((-1).bi, 2.bi), Rational(1.bi, (-2).bi))
    }

    @Test
    fun `normalizes zero`() {
        assertEquals(Rational.ZERO, Rational(BigInteger.ZERO, 7.bi))
        assertEquals("0", Rational(BigInteger.ZERO, 7.bi).toString())
    }

    @Test
    fun `performs exact arithmetic`() {
        val left = Rational(1.bi, 2.bi)
        val right = Rational(1.bi, 3.bi)

        assertEquals(Rational(5.bi, 6.bi), left + right)
        assertEquals(Rational(1.bi, 6.bi), left - right)
        assertEquals(Rational(1.bi, 6.bi), left * right)
        assertEquals(Rational(3.bi, 2.bi), left / right)
        assertEquals(Rational(2.bi), left.inverse())
    }

    @Test
    fun `rejects zero denominator and inverse of zero`() {
        assertThrows(IllegalArgumentException::class.java) { Rational(1.bi, BigInteger.ZERO) }
        assertThrows(IllegalArgumentException::class.java) { Rational.ZERO.inverse() }
    }
}

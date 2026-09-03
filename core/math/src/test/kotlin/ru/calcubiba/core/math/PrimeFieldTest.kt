package ru.calcubiba.core.math

import java.math.BigInteger
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows

class PrimeFieldTest {
    private val field = PrimeField(5.bi)

    @Test
    fun `normalizes positive values`() {
        assertEquals(2.bi, field.normalize(7.bi))
    }

    @Test
    fun `normalizes negative values`() {
        assertEquals(4.bi, field.normalize((-1).bi))
    }

    @Test
    fun `adds values modulo p`() {
        assertEquals(0.bi, field.add(2.bi, 3.bi))
    }

    @Test
    fun `subtracts values modulo p`() {
        assertEquals(4.bi, field.subtract(1.bi, 2.bi))
    }

    @Test
    fun `multiplies values modulo p`() {
        assertEquals(1.bi, field.multiply(2.bi, 3.bi))
    }

    @Test
    fun `finds inverse`() {
        assertEquals(2.bi, field.inverse(3.bi))
    }

    @Test
    fun `divides values modulo p`() {
        assertEquals(4.bi, field.divide(3.bi, 2.bi))
    }

    @Test
    fun `fails on inverse of zero`() {
        assertThrows(IllegalArgumentException::class.java) {
            field.inverse(BigInteger.ZERO)
        }
    }

    @Test
    fun `accepts prime modulus`() {
        val gf2 = PrimeField(2.bi)

        assertEquals(1.bi, gf2.add(1.bi, 0.bi))
        assertEquals(0.bi, gf2.add(1.bi, 1.bi))
    }

    @Test
    fun `rejects composite modulus`() {
        assertThrows(IllegalArgumentException::class.java) {
            PrimeField(9.bi)
        }
    }
}

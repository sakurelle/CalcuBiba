package ru.calcubiba.core.math

import java.math.BigInteger

internal val Int.bi: BigInteger
    get() = BigInteger.valueOf(toLong())

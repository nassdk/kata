import java.math.BigInteger

fun main() {
    print(
        lastDigit(
            BigInteger("2147483646"),
            BigInteger("2147483646")
        )
    )
}

fun lastDigit(base: BigInteger, exponent: BigInteger): Int {

    return if (exponent.toShort().toInt().toBigInteger() == exponent && (base.toShort().toInt().toBigInteger() == base || exponent.toInt() == 0))
        (base.pow(exponent.toInt())).toString().last().toString().toInt()
    else {
        val value = base.toString().last().toString().toBigInteger()
        val exp = exponent.toString().substring(exponent.toString().count() - 2 until exponent.toString().count()).toInt()
        val result = value.pow(exp).toString().last().toString().toInt()
        if (value == (0).toBigInteger() && exp == 0) 0 else result
    }
}

fun betterLastDigit(base: BigInteger, exponent: BigInteger) = base.modPow(exponent, BigInteger.TEN).toInt()
package boj2407

import java.math.BigInteger

fun main() {
    val nums = readln().split(" ").map { x -> x.toInt() }
    val n = nums[0]
    var m = nums[1]
    var result = BigInteger.valueOf(1)

    if (m > n / 2) {
        m = n - m
    }

    for (i in m downTo 1) {
        result = result.multiply((n - m + i).toBigInteger())
        result = result.divide((m - i + 1).toBigInteger())
    }

    println(result)
}

package boj11444

val BASE = 1000000007
val A = arrayOf(longArrayOf(1, 1), longArrayOf(1, 0))
val dp = HashMap<Long, Array<LongArray>?>()

fun multiply(arr1: Array<LongArray>, arr2: Array<LongArray>): Array<LongArray> {
    val result = arrayOf(longArrayOf(0, 0), longArrayOf(0, 0))

    result[0][0] = ((arr1[0][0] * arr2[0][0]) % BASE + (arr1[0][1] * arr2[1][0]) % BASE) % BASE
    result[0][1] = ((arr1[0][0] * arr2[0][1]) % BASE + (arr1[0][1] * arr2[1][1]) % BASE) % BASE
    result[1][0] = ((arr1[1][0] * arr2[0][0]) % BASE + (arr1[1][1] * arr2[1][0]) % BASE) % BASE
    result[1][1] = ((arr1[1][0] * arr2[0][1]) % BASE + (arr1[1][1] * arr2[1][1]) % BASE) % BASE

    return result
}

fun A_n(n: Long): Array<LongArray> {
    val cache = dp.getOrDefault(n, null)
    if (cache != null) {
        return cache
    }

    val half = A_n(n / 2)
    var result = multiply(half, half)
    if (n % 2 > 0) {
        result = multiply(result, A)
    }
    dp.put(n, result)

    return result
}

fun main() {
    val n = readln().toLong()
    dp.put(1, A)
    print(A_n(n)[0][1])
}

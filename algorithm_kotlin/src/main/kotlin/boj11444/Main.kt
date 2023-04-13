package boj11444

val BASE = 1000000007
val A = arrayOf(intArrayOf(1, 1), intArrayOf(1, 0))
val dp = HashMap<Long, Array<IntArray>?>()

fun Array<IntArray>.toLongArray(): List<List<Long>> {
    return this.map { r -> r.map { x -> x.toLong() } }
}

fun Array<LongArray>.toLongArray(): Array<IntArray> {
    return this.map { r -> r.map { x -> x.toInt() }.toIntArray() }.toTypedArray()
}

fun multiply(left: Array<IntArray>, right: Array<IntArray>): Array<IntArray> {
    val result = arrayOf(longArrayOf(0, 0), longArrayOf(0, 0))

    val arr1 = left.toLongArray()
    val arr2 = right.toLongArray()

    result[0][0] = (arr1[0][0] * arr2[0][0] + arr1[0][1] * arr2[1][0]) % BASE
    result[0][1] = (arr1[0][0] * arr2[0][1] + arr1[0][1] * arr2[1][1]) % BASE
    result[1][0] = (arr1[1][0] * arr2[0][0] + arr1[1][1] * arr2[1][0]) % BASE
    result[1][1] = (arr1[1][0] * arr2[0][1] + arr1[1][1] * arr2[1][1]) % BASE

    return result.toLongArray()
}

fun A_n(n: Long): Array<IntArray> {
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

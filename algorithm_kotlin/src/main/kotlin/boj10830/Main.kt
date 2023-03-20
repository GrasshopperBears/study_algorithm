package boj10830

fun print2DArray(arr: Array<IntArray>) {
    val sb = StringBuilder()
    for (row in arr) {
        for (col in row) {
            sb.append(col).append(' ')
        }
        sb.append('\n')
    }
    println(sb.toString())
}

fun setUnitMatrix(arr: Array<(IntArray)>, size: Int) {
    for (i in 0 until size) {
        arr[i][i] = 1
    }
}

fun multiply(left: Array<IntArray>, right: Array<IntArray>, size: Int): Array<IntArray> {
    val result = Array(size) { IntArray(size) }

    for (i in 0 until size) {
        for (j in 0 until size) {
            for (k in 0 until size) {
                result[i][j] += left[i][k] * right[k][j]
                result[i][j] %= 1000
            }
        }
    }
    return result
}

fun main() {
    val firstLine = readln().split(" ").map { x -> x.toLong() }
    val n = firstLine[0].toInt()
    var e = firstLine[1]

    var result = Array(n) { IntArray(n) }
    var current = Array(n) { IntArray(n) }
    var currentExp = 1L

    setUnitMatrix(result, n)

    for (i in 0 until n) {
        val nums = readln().split(" ").map { x -> x.toInt() }
        for (j in 0 until n) {
            current[i][j] = nums[j]
        }
    }

    while (e > 0) {
        if ((currentExp and e) > 0) {
            result = multiply(result, current, n)
            e -= currentExp
        }
        currentExp = currentExp shl 1
        current = multiply(current, current, n)
    }

    print2DArray(result)
}

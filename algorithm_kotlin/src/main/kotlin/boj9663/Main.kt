package boj9663

var colSet = booleanArrayOf()
var rtDiagSet = booleanArrayOf()
var rdDiagSet = booleanArrayOf()
var n = 0
var result = 0

fun nQueen(row: Int) {
    for (col in 0 until n) {
        if (colSet[col] || rdDiagSet[col - row + n] || rtDiagSet[col + row]) {
            continue
        }

        if (row == n - 1) {
            result++
            continue
        }

        colSet[col] = true
        rdDiagSet[col - row + n] = true
        rtDiagSet[col + row] = true

        nQueen(row + 1)

        colSet[col] = false
        rdDiagSet[col - row + n] = false
        rtDiagSet[col + row] = false
    }
}

fun main() {
    n = readln().toInt()
    colSet = BooleanArray(n)
    rtDiagSet = BooleanArray(2 * n + 1)
    rdDiagSet = BooleanArray(2 * n + 1)

    nQueen(0)
    println(result)
}

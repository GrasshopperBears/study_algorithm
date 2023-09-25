package boj1987

import kotlin.math.max

var rows = 0
var cols = 0
var max = 0

val alphabets = BooleanArray(26)

var board = arrayOf(charArrayOf())
var visited = arrayOf(booleanArrayOf())

val directions = arrayOf(0, 1, 0, -1, 0)

private fun Char.toIndex() = this - 'A'

fun dfs(row: Int, col: Int, depth: Int) {
    val c = board[row][col]
    if (visited[row][col] || alphabets[c.toIndex()]) return

    max = max(max, depth)

    alphabets[c.toIndex()] = true
    visited[row][col] = true

    for (i in 0 until 4) {
        val nextRow = row + directions[i]
        val nextCol = col + directions[i + 1]

        if (nextRow < 0 || nextCol < 0 || nextRow >= rows || nextCol >= cols) continue

        dfs(nextRow, nextCol, depth + 1)
    }

    visited[row][col] = false
    alphabets[c.toIndex()] = false
}

fun main() {
    val t = readln().split(' ').map { x -> x.toInt() }
    rows = t[0]
    cols = t[1]

    board = arrayOfNulls<CharArray>(rows).map { _ -> CharArray(cols) }.toTypedArray()
    visited = arrayOfNulls<BooleanArray>(rows).map { _ -> BooleanArray(cols) }.toTypedArray()

    for (i in 0 until rows) {
        val l = readln()
        for (j in 0 until cols) {
            board[i][j] = l[j]
        }
    }

    dfs(0, 0, 1)
    println(max)
}

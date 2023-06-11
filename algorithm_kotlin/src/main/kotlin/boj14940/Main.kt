package boj14940

var ground = arrayOf(arrayOf<Boolean>())
var dists = arrayOf(arrayOf<Int>())
var rows = 0
var cols = 0
var targetRow = 0
var targetCol = 0
val directions = arrayOf(0, -1, 0, 1, 0)
private val q = ArrayDeque<Pos>()

private data class Pos(val row: Int, val col: Int, val dist: Int)

fun bfs() {
    while (q.size > 0) {
        val (row, col, dist) = q.removeFirst()
        if (dists[row][col] >= 0) continue
        dists[row][col] = dist

        for (i in 0 until 4) {
            val nextRow = row + directions[i]
            val nextCol = col + directions[i + 1]
            if (nextRow >= 0 && nextCol >= 0 && nextRow < rows && nextCol < cols && ground[nextRow][nextCol] && dists[nextRow][nextCol] < 0) {
                q.add(Pos(nextRow, nextCol, dist + 1))
            }
        }
    }
}

fun printDist() {
    val result = StringBuilder()
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            val dist = dists[i][j]
            result.append(if(dist >= 0 || ground[i][j]) dists[i][j] else 0).append(' ')
        }
        result.append('\n')
    }
    println(result.toString())
}

fun main() {
    var line = readln().split(" ").map { x -> x.toInt() }
    rows = line[0]
    cols = line[1]
    ground = arrayOfNulls<Boolean>(rows).map { _ -> BooleanArray(cols).toTypedArray() }.toTypedArray()
    dists = arrayOfNulls<Int>(rows).map { _ -> IntArray(cols) { _ -> -1 }.toTypedArray() }.toTypedArray()

    for (i in 0 until rows) {
        line = readln().split(" ").map { x -> x.toInt() }
        for (j in 0 until cols) {
            val curr = line[j]
            if (curr == 0) {
                continue
            }
            ground[i][j] = true
            if (curr == 2) {
                targetRow = i
                targetCol = j
            }
        }
    }
    q.add(Pos(targetRow, targetCol, 0))
    bfs()
    printDist()
}

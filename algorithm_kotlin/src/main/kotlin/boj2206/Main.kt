package boj2206

val DIRECTIONS = arrayOf(0, -1, 0, 1, 0)
var mat = arrayOf<String>()
var visited = arrayOf(arrayOf(arrayOf<Boolean>()))
var rows = 0
var cols = 0
private val q = ArrayDeque<Plan>()

private data class Plan(val row: Int, val col: Int, val dist: Int, val isBroken: Boolean)

fun getVisited(i: Int, j: Int, isBroken: Boolean): Boolean {
    return visited[i][j][if (isBroken) 0 else 1]
}

fun setVisited(i: Int, j: Int, isBroken: Boolean) {
    visited[i][j][if (isBroken) 0 else 1] = true
}

fun bfs(): Int {
    while (!q.isEmpty()) {
        val (row, col, dist, isBroken) = q.removeFirst()

        if (row == rows - 1 && col == cols - 1) {
            return dist
        }
        if (getVisited(row, col, isBroken)) {
            continue
        }
        setVisited(row, col, isBroken)

        for (dir in 0 until 4) {
            val nextRow = row + DIRECTIONS[dir]
            val nextCol = col + DIRECTIONS[dir + 1]
            if (nextRow < 0 || nextCol < 0 || nextRow >= rows || nextCol >= cols) {
                continue
            }
            val isNextWall = mat[nextRow][nextCol] == '1'
            if (isBroken) {
                if (isNextWall || getVisited(nextRow, nextCol, false)) {
                    continue
                }
            }
            q.addLast(Plan(nextRow, nextCol, dist + 1, isBroken || isNextWall))
        }
    }
    return -1
}

fun main() {
    val nums = readln().split(" ").map { x -> x.toInt() }
    rows = nums[0]
    cols = nums[1]
    mat = arrayOfNulls<String>(rows).map { _ -> "" }.toTypedArray()
    visited = arrayOfNulls<Boolean>(rows).map { _ -> arrayOfNulls<Boolean>(cols).map { _ -> BooleanArray(2).toTypedArray() }.toTypedArray() }.toTypedArray()

    for (i in 0 until rows) {
        mat[i] = readln()
    }

    q.addLast(Plan(0, 0, 1, false))
    println(bfs())
}

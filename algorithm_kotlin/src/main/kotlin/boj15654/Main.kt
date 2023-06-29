package boj15654

var n = 0
var numbers = intArrayOf()
var visited = booleanArrayOf()
var selectCount = 0
val sb = StringBuilder()
val stack = arrayListOf<Int>()

fun dfs(idx: Int, depth: Int) {
    if (visited[idx]) {
        return
    }
    visited[idx] = true
    stack.add(numbers[idx])

    if (depth == selectCount) {
        val c = stack.fold(StringBuilder()) { acc, i -> acc.append(i).append(' ') }
        sb.append(c).append('\n')
    } else {
        for (i in 0 until n) {
            dfs(i, depth + 1)
        }
    }
    stack.removeLast()
    visited[idx] = false
}

fun main() {
    val line = readln().split(" ").map { x -> x.toInt() }
    n = line[0]
    selectCount = line[1]
    numbers = IntArray(n)
    visited = BooleanArray(n)
    readln().split(" ")
        .map { x -> x.toInt() }
        .forEachIndexed { i, num ->
            numbers[i] = num
        }
    numbers.sort()

    for (i in 0 until n) {
        dfs(i, 1)
    }

    println(sb.toString())
}

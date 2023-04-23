package boj11725

class Edge {
    val edges: MutableList<Int> = ArrayList()
}

var visited = BooleanArray(0)
var connected: Array<Edge> = emptyArray()
var parents = IntArray(0)

fun dfs(node: Int, parent: Int) {
    if (visited[node]) {
        return
    }
    visited[node] = true
    parents[node] = parent

    for (edge in connected[node].edges) {
        dfs(edge, node)
    }
    visited[node] = false
}

fun printParents() {
    val result = StringBuilder()

    for (i in 2 until parents.size) {
        result.append(parents[i]).append('\n')
    }
    println(result.toString())
}

fun main() {
    val n = readln().toInt()
    visited = BooleanArray(n+1)
    connected = arrayOfNulls<Edge>(n+1).map { x -> Edge() }.toTypedArray()
    parents = IntArray(n+1)

    for (i in 0 until n-1) {
        val nums = readln().split(" ").map { x -> x.toInt() }
        val node1 = nums[0]
        val node2 = nums[1]
        connected[node1].edges.add(node2)
        connected[node2].edges.add(node1)
    }
    dfs(1, 0)
    printParents()
}

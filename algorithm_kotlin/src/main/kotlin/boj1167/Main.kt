package boj1167

import kotlin.math.max

class Node() {
    val edges = mutableListOf<Edge>()
}

data class Edge(val node: Int, val dist: Int)

var nodes: Array<Node> = emptyArray()
var visited: BooleanArray = BooleanArray(0)
var maxDist = 0

fun dfs(node: Int, currDist: Int): Int {
    if (visited[node]) {
        return 0
    }

    val curr = nodes[node]
    var max1 = 0
    var max2 = 0

    for ((childNode, dist) in curr.edges) {
        if (visited[childNode]) {
            continue
        }

        visited[node] = true
        val childResult = dfs(childNode, dist)
        visited[node] = false

        if (childResult > max1) {
            max2 = max1
            max1 = childResult
        } else if (childResult > max2) {
            max2 = childResult
        }
    }

    val currMaxDist = max(max1, max2) + currDist
    maxDist = max(maxDist, max(max1 + max2, currMaxDist))
    return currMaxDist
}

fun main() {
    val n = readln().toInt()
    nodes = Array<Node>(n + 1) { Node() }
    visited = BooleanArray(n + 1)

    for (i in 0 until n) {
        val nums = readln().split(" ").map { c -> c.toInt() }
        val from = nums[0]
        var pos = 1

        while (nums[pos] > 0) {
            nodes[from].edges.add(Edge(nums[pos], nums[pos + 1]))
            pos += 2
        }
    }

    dfs(1, 0)
    print(maxDist)
}

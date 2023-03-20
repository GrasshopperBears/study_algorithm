package boj1967

import kotlin.math.max

var maxRadius = 0

fun dfs(nodeIdx: Int, nodes: Array<Node>, weights: IntArray): Int {
    val node = nodes[nodeIdx]
    var maxChild = 0

    if (nodeIdx == 0) {
        return 0
    }

    for (child in node.children) {
        val childRadius = dfs(child, nodes, weights)
        maxRadius = max(maxRadius, maxChild + childRadius)
        if (childRadius > maxChild) {
            maxChild = childRadius
        }
    }

    return maxChild + weights[nodeIdx]
}

fun main() {
    val n = readln().toInt()
    val nodes = Array(n+1) { Node() }
    val weights = IntArray(n+1)

    for (i in 0 until n-1) {
        val tokens = readln().split(" ").map { x -> x.toInt() }
        val parentIdx = tokens[0]
        val childIdx = tokens[1]
        val parent = nodes[parentIdx]
        parent.addChild(childIdx)
        weights[childIdx] = tokens[2]
    }

    dfs(1, nodes, weights)
    println(maxRadius)
}

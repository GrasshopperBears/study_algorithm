package boj1753

import java.util.PriorityQueue
import kotlin.math.min

data class NextNode(val pos: Int, val dist: Int) : Comparable<NextNode> {
    override fun compareTo(other: NextNode): Int {
        return dist.compareTo(other.dist)
    }
}

var graph = arrayOf(mutableMapOf<Int, Int>())
var dists = arrayOf<Int>()
var visited = arrayOf<Boolean>()
var points = 0

fun print() {
    val result = StringBuilder()
    for (i in 1..points) {
        result.append(if (dists[i] == Int.MAX_VALUE) "INF" else dists[i]).append('\n')
    }
    println(result.toString())
}

fun main() {
    var tokens = readln().split(" ").map { x -> x.toInt() }
    points = tokens[0]
    val edges = tokens[1]
    val from = readln().toInt()
    val q = PriorityQueue<NextNode>()

    graph = arrayOfNulls<Map<Int, Int>>(points + 1).map { _ -> mutableMapOf<Int, Int>() }.toTypedArray()
    visited = BooleanArray(points + 1).toTypedArray()
    dists = IntArray(points + 1) { _ -> Int.MAX_VALUE }.toTypedArray()

    for (i in 0 until edges) {
        tokens = readln().split(" ").map { x -> x.toInt() }
        val u = tokens[0]
        val v = tokens[1]
        val w = tokens[2]
        graph[u][v] = min(w, graph[u].getOrDefault(v, Int.MAX_VALUE))
    }

    q.add(NextNode(from, 0))

    while (q.size > 0) {
        val (pos, dist) = q.poll()
        if (visited[pos]) continue
        visited[pos] = true
        dists[pos] = min(dists[pos], dist)
        for ((adj, adjDist) in graph[pos]) {
            if (!visited[adj]) {
                q.add(NextNode(adj, dist + adjDist))
            }
        }
    }

    print()
}

package boj1865

var cost = intArrayOf()
var graph = arrayOf(mutableMapOf<Int, Int>())

var points = 0
var roads = 0
var wormholes = 0

fun iterate(action: (Int, Int, Int) -> Unit) {
    for (from in 1..points) {
        for ((to, c) in graph[from]) {
            if (cost[from] + c < cost[to]) {
                action(from, to, c)
            }
        }
    }
}

fun detectNegativeCycle(): Boolean {
    var isNegative = false

    for (iteration in 1 until points) {
        iterate { from, to, c ->
            cost[to] = cost[from] + c
        }
    }
    iterate { _, _, _ ->
        isNegative = true
    }
    return isNegative
}

fun main() {
    val tc = readln().toInt()

    for (t in 1..tc) {
        var line = readln().split(" ").map { it.toInt() }
        points = line[0]
        roads = line[1]
        wormholes = line[2]

        cost = IntArray(points + 1) { 25000001 }
        graph = arrayOfNulls<Map<Int, Int>>(points + 1).map { mutableMapOf<Int, Int>() }.toTypedArray()

        for (r in 1..roads) {
            line = readln().split(" ").map { it.toInt() }
            val from = line[0]
            val to = line[1]
            val cost = line[2]
            val lastCost = graph[from][to]

            if (lastCost == null || cost < lastCost) {
                graph[from][to] = cost
                graph[to][from] = cost
            }
        }

        for (w in 1..wormholes) {
            line = readln().split(" ").map { it.toInt() }
            val from = line[0]
            val to = line[1]
            val reduce = -line[2]

            if (reduce <= graph[from].getOrDefault(to, 0)) {
                graph[from][to] = reduce
            }
        }
        cost[1] = 0
        println(if (detectNegativeCycle()) "YES" else "NO")
    }
}

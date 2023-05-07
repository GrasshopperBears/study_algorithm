package boj11404

import kotlin.math.min

var graph = arrayOf(arrayOf<Int>())

fun main() {
    val citiesNum = readln().toInt()
    val busesNum = readln().toInt()
    graph = arrayOfNulls<Int>(citiesNum).map { _ -> IntArray(citiesNum).toTypedArray() }.toTypedArray()

    for (i in 0 until busesNum) {
        val line = readln().split(" ").map { x -> x.toInt() }
        val from = line[0] - 1
        val to = line[1] - 1
        val cost = line[2]
        graph[from][to] = if (graph[from][to] == 0) cost else min(graph[from][to], cost)
    }

    for (i in 0 until citiesNum) {
        for (j in 0 until citiesNum) {
            for (k in 0 until citiesNum) {
                if (j == k || graph[j][i] == 0 || graph[i][k] == 0) continue
                val newCost = graph[j][i] + graph[i][k]
                graph[j][k] = if (graph[j][k] == 0) newCost else min(graph[j][k], newCost)
            }
        }
    }

    val result = StringBuilder()
    for (i in 0 until citiesNum) {
        result.append(graph[i].joinToString(" ")).append('\n')
    }
    println(result.toString())
}

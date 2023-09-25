package boj1766

import java.util.PriorityQueue

fun main() {
    var l = readln().split(' ').map { x -> x.toInt() }
    val questions = l[0]
    val info = l[1]
    val inbounds = IntArray(questions + 1)
    val noInbounds = PriorityQueue<Int>()
    val graph = arrayOfNulls<Set<Int>>(questions + 1).map { _ -> mutableSetOf<Int>() }
    val result = StringBuilder()

    for (i in 0 until info) {
        l = readln().split(' ').map { x -> x.toInt() }
        val from = l[0]
        val to = l[1]

        inbounds[to]++
        graph[from].add(to)
    }

    for (i in 1..questions) {
        if (inbounds[i] == 0) noInbounds.add(i)
    }

    while (noInbounds.size > 0) {
        val now = noInbounds.poll()
        result.append(now).append(' ')

        for (adj in graph[now]) {
            val updatedAdjInbound = --inbounds[adj]
            if (updatedAdjInbound == 0) noInbounds.add(adj)
        }
    }

    println(result.toString())
}

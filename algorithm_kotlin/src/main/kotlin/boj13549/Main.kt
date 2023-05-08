package boj13549

import java.util.PriorityQueue
import kotlin.math.abs

data class Move(val pos: Int, val time: Int)

val MAX_POS = 100000
val visited = BooleanArray(MAX_POS + 1)
val q = PriorityQueue<Move> { x, y -> x.time - y.time }

fun isValidPos(pos: Int): Boolean {
    return pos in 0..MAX_POS
}

fun addIfNotVisited(pos: Int, time: Int) {
    if (isValidPos(pos) && !visited[pos]) {
        q.add(Move(pos, time))
    }
}

fun main() {
    val numbers = readln().split(" ").map { x -> x.toInt() }
    val from = numbers[0]
    val to = numbers[1]

    if (to <= from) {
        println(abs(from - to))
        return
    }

    q.add(Move(from, 0))

    while (q.size > 0) {
        val (pos, time) = q.poll()
        if (visited[pos]) {
            continue
        }
        if (pos == to) {
            println(time)
            return
        }

        visited[pos] = true

        addIfNotVisited(pos shl 1, time)
        addIfNotVisited(pos + 1, time + 1)
        addIfNotVisited(pos - 1, time + 1)
    }
}

package boj12865

import kotlin.math.max

var dp = intArrayOf()
var objects = arrayOf<Obj>()

data class Obj(var weight: Int, var value: Int)

fun knapsack() {
    for (obj in objects) {
        for (i in dp.size - 1 downTo 0) {
            val prevWeight = i - obj.weight
            if (prevWeight < 0) {
                continue
            }
            dp[i] = max(dp[i], dp[prevWeight] + obj.value)
        }
    }
}

fun main() {
    var numbers = readln().split(" ").map { x -> x.toInt() }
    val objectNumber = numbers[0]
    val maxWeight = numbers[1]

    dp = IntArray(maxWeight + 1)
    objects = arrayOfNulls<Obj>(objectNumber).map { x -> Obj(0, 0) }.toTypedArray()

    for (i in 0 until objectNumber) {
        numbers = readln().split(" ").map { x -> x.toInt() }
        objects[i].weight = numbers[0]
        objects[i].value = numbers[1]
    }
    knapsack()
    println(dp[maxWeight])
}

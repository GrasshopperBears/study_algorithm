package boj15666

var nums: List<Int> = emptyList()
var pointers: IntArray = IntArray(0)
val sb = StringBuilder()

fun print() {
    for (pointer in pointers) {
        sb.append(nums[pointer]).append(' ')
    }
    sb.append('\n')
}

fun proceed(pointerIdx: Int) {
    var currIdx = pointers[pointerIdx]
    val prev = nums[currIdx++]

    while (currIdx < nums.size && nums[currIdx] == prev) {
        currIdx++
    }

    if (currIdx == nums.size && pointerIdx > 0) {
        proceed(pointerIdx - 1)
        pointers[pointerIdx] = pointers[pointerIdx - 1]
    } else {
        pointers[pointerIdx] = currIdx
    }
}

fun main() {
    val tokens = readln().split(" ").map { x -> x.toInt() }
    val n = tokens[0]
    val m = tokens[1]

    nums = readln().split(" ").map { x -> x.toInt() }.sorted()
    pointers = IntArray(m)

    while (pointers[0] < n) {
        print()
        proceed(m - 1)
    }

    println(sb.toString())
}

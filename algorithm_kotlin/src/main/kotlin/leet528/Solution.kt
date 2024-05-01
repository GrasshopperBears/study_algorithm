package leet528

class Solution(w: IntArray) {
    private val indexedSum = mutableListOf<Int>()
    private var ptr = 0
    private var idx = 0

    init {
        w.fold(0) { acc, curr ->
            println(acc)
            indexedSum.add(acc)
            acc + curr
        }
    }

    fun pickIndex(): Int {
        val result = idx
        ptr++

        if (ptr >= indexedSum[idx]) {
            idx++
        }
        if (idx == indexedSum.size) {
            idx = 0
        }

        return result
    }
}

fun main() {
    val s = Solution(intArrayOf(0))
    println(s.pickIndex())
}

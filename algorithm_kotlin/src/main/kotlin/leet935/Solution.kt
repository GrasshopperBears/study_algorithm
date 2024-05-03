package leet935

class Solution {
    companion object {
        private const val MODULO = 1000000007
        private val movements = listOf(
            listOf(4, 6),
            listOf(6, 8),
            listOf(7, 9),
            listOf(4, 8),
            listOf(0, 3, 9),
            listOf(),
            listOf(0, 1, 7),
            listOf(2, 6),
            listOf(1, 3),
            listOf(2, 4),
        )
    }

    private val dp1 = LongArray(10).map { _ -> 1L }.toMutableList()
    private val dp2 = LongArray(10).map { _ -> 1L }.toMutableList()
    private var use1 = true

    fun knightDialer(n: Int): Int {
        for (x in 1 until n) {
            for (i in 0..9) {
                val prev = if (use1) { dp2 } else { dp1 }
                val curr = if (use1) { dp1 } else { dp2 }

                curr[i] = movements[i].fold(0L) { acc, num ->
                    (acc + prev[num]) % MODULO
                }
            }
            use1 = use1.not()
        }

        val last = if (use1) { dp2 } else { dp1 }

        return last.fold(0L) { acc, curr ->
            (acc + curr) % MODULO
        }.toInt()
    }
}

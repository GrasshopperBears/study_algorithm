package leet131

class Solution {
    val result: MutableList<List<String>> = arrayListOf()
    var dp: List<BooleanArray> = arrayListOf()
    var size = 0
    var str = ""

    private fun putResult(stack: List<Int>) {
        val el = mutableListOf<String>()
        var prev = 0
        for (i in stack) {
            el.add(str.substring(prev, i + 1))
            prev = i + 1
        }

        result.add(el)
    }

    private fun getIndices(stack: MutableList<Int>, from: Int) {
        if (from >= size) {
            putResult(stack)
            return
        }

        for (to in from until size) {
            if (dp[from][to]) {
                stack.add(to)
                getIndices(stack, to + 1)
                stack.removeLast()
            }
        }
    }

    fun partition(s: String): List<List<String>> {
        str = s
        size = s.length
        dp = arrayOfNulls<BooleanArray>(size).map { _ -> BooleanArray(size) }

        for (i in 0 until size) dp[i][i] = true

        for (i in 0 until size) {
            var from = 0
            var to = i
            while (to < size) {
                if (from == to) dp[from][to] = true
                else if (s[from] == s[to]) {
                    if (to - from == 1) dp[from][to] = true
                    else dp[from][to] = dp[from+1][to-1]
                }

                from++
                to++
            }
        }

        getIndices(arrayListOf(), 0)

        return result
    }
}

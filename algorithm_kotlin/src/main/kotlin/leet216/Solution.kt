package leet216

class Solution {
    val result = mutableListOf<List<Int>>()
    var total = 0
    var max = 0
    val stack = mutableListOf<Int>()
    var currentSum = 0

    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        max = k
        total = n
        dfs(1)
        return result
    }

    private fun dfs(num: Int) {
        println("num: $num, stack: $stack, currentSum: $currentSum")
        if (stack.size == max && currentSum == total) {
            result.add(stack.toList())
            return
        }
        if (num == 10) {
            return
        }
        if (currentSum + num <= total) {
            stack.add(num)
            currentSum += num
            dfs(num + 1)
            currentSum -= num
            stack.removeLast()
        }

        dfs(num + 1)
    }
}

package leet39

class Solution {
    var candidates = intArrayOf()
    val result: MutableList<List<Int>> = arrayListOf()
    var counts = intArrayOf()

    private fun putResult() {
        val el = mutableListOf<Int>()

        for (i in counts.indices) {
            for (j in 0 until counts[i]) {
                el.add(candidates[i])
            }
        }

        result.add(el)
    }

    private fun getPossible(index: Int, remain: Int) {
        if (remain < 0) return
        if (index == counts.size) {
            if (remain == 0) putResult()
            return
        }

        val current = candidates[index]

        for (i in 0..remain/current) {
            counts[index] = i
            getPossible(index+1, remain-current*i)
        }
    }

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        this.candidates = candidates
        counts = IntArray(candidates.size)
        getPossible(0, target)
        return result
    }
}

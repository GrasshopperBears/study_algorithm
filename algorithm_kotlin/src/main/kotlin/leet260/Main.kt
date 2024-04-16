package leet260

class Main {
    fun singleNumber(nums: IntArray): IntArray {
        val once = mutableSetOf<Int>()
        val twice = mutableSetOf<Int>()

        for (num in nums) {
            if (twice.contains(num)) {
                continue
            }
            if (once.contains(num)) {
                once.remove(num)
                twice.add(num)
                continue
            }
            once.add(num)
        }

        return once.toIntArray()
    }
}
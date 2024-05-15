package leet340

import kotlin.math.max

class Solution {
    fun lengthOfLongestSubstringKDistinct(s: String, k: Int): Int {
        if (k == 0) return 0

        val counts = mutableMapOf<Char, Int>()
        var longest = 0
        var left = 0

        for (i in s.indices) {
            val c = s[i]
            counts[c] = counts.getOrDefault(c, 0) + 1

            if (counts.size > k) {
                while (counts.size > k) {
                    val lc = s[left]
                    counts[lc] = counts[lc]!! - 1
                    if (counts[lc] == 0) {
                        counts.remove(lc)
                    }
                    left++
                }
            }
            longest = max(longest, i - left + 1)
        }

        return longest
    }
}

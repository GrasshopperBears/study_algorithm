package boj9465

import java.lang.StringBuilder
import kotlin.math.max

fun getMaxStickers(stickers: Array<Array<Int>>): Int {
    val dp = arrayOf(0, 0, 0)
    for (i in 0 until stickers[0].size) {
        val (prevTopSelected, prevBottomSelected, prevNoneSelected) = dp
        val currTop = stickers[0][i]
        val currBottom = stickers[1][i]

        dp[0] = max(prevBottomSelected + currTop, prevNoneSelected + currTop)
        dp[1] = max(prevTopSelected + currBottom,  prevNoneSelected + currBottom)
        dp[2] = max(prevTopSelected, max(prevBottomSelected, prevNoneSelected))
    }
    return dp.max()
}

private fun parseInput(): Array<Array<Int>> {
    readln()
    val stickers = arrayOf(arrayOf<Int>(), arrayOf<Int>())

    stickers[0] = readln().split(" ").map { it.toInt() }.toTypedArray()
    stickers[1] = readln().split(" ").map { it.toInt() }.toTypedArray()

    return stickers
}

fun main() {
    val sb = StringBuilder()
    val tc = readln().toInt()
    for (t in 1..tc) {
        val stickers = parseInput()
        sb.append(getMaxStickers(stickers)).append('\n')
    }
    print(sb.toString())
}

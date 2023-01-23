package boj2630

class CountResult() {
    var white = 0
    var blue = 0

    constructor(white: Int, blue: Int) : this() {
        this.white = white
        this.blue = blue
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CountResult

        if (white != other.white) return false
        if (blue != other.blue) return false

        return true
    }

    override fun hashCode(): Int {
        var result = white
        result = 31 * result + blue
        return result
    }
}

private fun getBasePaper(isBlue: Boolean, result: CountResult): CountResult {
    if (isBlue) {
        result.blue++
    } else {
        result.white++
    }
    return result
}

fun count(papers: Array<BooleanArray>, fromR: Int, fromC: Int, size: Int): CountResult {
    val isBlue = papers[fromR][fromC]
    val result = CountResult()

    if (size == 1) {
        return getBasePaper(isBlue, result)
    }

    var flag = true
    loop@ for (r in fromR until fromR + size) {
        for (c in fromC until fromC + size) {
            if (isBlue != papers[r][c]) {
                flag = false
                break@loop
            }
        }
    }

    if (flag) {
        return getBasePaper(isBlue, result)
    }

    val half = size / 2
    val leftTop = count(papers, fromR, fromC, half)
    val rightTop = count(papers, fromR, fromC + half, half)
    val leftBottom = count(papers, fromR + half, fromC, half)
    val rightBottom = count(papers, fromR + half, fromC + half, half)

    result.white += (leftTop.white + rightTop.white + leftBottom.white + rightBottom.white)
    result.blue += (leftTop.blue + rightTop.blue + leftBottom.blue + rightBottom.blue)

    return result
}

fun parseInput(len: Int): Array<BooleanArray> {
    val input = Array(len) { BooleanArray(len) }

    for (i in 0 until len) {
        input[i] = readln().split(" ").map { it[0] == '1' }.toBooleanArray()
    }
    return input
}

fun main() {
    val len = readln().toInt()
    val papers = parseInput(len)
    val countResult = count(papers, 0, 0, len)

    println(countResult.white)
    println(countResult.blue)
}

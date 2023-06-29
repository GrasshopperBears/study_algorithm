package boj18110

fun round(num: Double): Int {
    val tmp = (num * 10).toInt()
    return if (tmp % 10 >= 5) tmp / 10 + 1 else tmp / 10
}

fun main() {
    val n = readln().toInt()

    val numbers = IntArray(n)
    for (i in 0 until n)
        numbers[i] = readln().toInt()
    numbers.sort()

    var sum = 0
    val cap = round(n.toDouble() * 3 / 20)
    for (i in cap until (n - cap))
        sum += numbers[i]

    println(round(sum.toDouble() / (n - 2 * cap)))
}

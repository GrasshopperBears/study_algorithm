package boj5639

var numbers = mutableListOf<Int>()
val result = StringBuilder()

fun visit(from: Int, to: Int) {
    if (from == to) {
        return
    }

    if (to - from > 1) {
        val number = numbers[from]
        var bigger = from + 1

        for (i in from + 1 until to) {
            if (numbers[i] > number) {
                break
            }
            bigger++
        }

        visit(from+1, bigger)
        visit(bigger, to)
    }

    result.append(numbers[from]).append('\n')
}

fun main() {
    while(true) {
        val number = readlnOrNull()?.toInt() ?: break
        numbers.add(number)
    }

    visit(0, numbers.size)

    println(result.toString())
}

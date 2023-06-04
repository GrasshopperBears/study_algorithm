package boj1918

import java.util.Stack

val stack = Stack<Char>()

private fun Char.isOpen(): Boolean = this == '('
private fun Char.isClose(): Boolean = this == ')'
private fun Char.isPlusMinus(): Boolean = this == '+' || this == '-'
private fun Char.isMulDiv(): Boolean = this == '*' || this == '/'

fun x(): Int = 3

fun main() {
    val line = readln()
    val result = StringBuilder()
    var pos = 0

    while (pos < line.length) {
        val c = line[pos++]
        if (c.isOpen()) {
            stack.add(c)
        } else if (c.isClose()) {
            while (true) {
                val last = stack.pop()
                if (last.isOpen()) {
                    break
                }
                result.append(last)
            }
        } else if (c.isPlusMinus()) {
            while (stack.size > 0) {
                val last = stack.peek()
                if (!last.isOpen()) {
                    result.append(stack.pop())
                } else {
                    break
                }
            }
            stack.add(c)
        } else if (c.isMulDiv()) {
            while (stack.size > 0) {
                val last = stack.peek()
                if (last.isMulDiv()) {
                    result.append(stack.pop())
                } else {
                    break
                }
            }
            stack.add(c)
        } else {
            result.append(c)
        }
    }

    while (stack.size > 0) {
        result.append(stack.pop())
    }

    println(result.toString())
}

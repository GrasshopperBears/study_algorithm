package leet155

class MinStack() {
    val totalStack = mutableListOf<Int>()
    val trackMinStack = mutableListOf<MinStackNode>()

    fun push(`val`: Int) {
        totalStack.add(`val`)

        if (trackMinStack.size == 0 || trackMinStack.last().value > `val`) {
            trackMinStack.add(MinStackNode(`val`))
        } else if (trackMinStack.last().value == `val`) {
            trackMinStack.last().count++
        }
    }

    fun pop() {
        val last = totalStack.removeLast()
        val currentMin = trackMinStack.last()

        if (currentMin.value == last) {
            currentMin.count--
            if (currentMin.count == 0) {
                trackMinStack.removeLast()
            }
        }
    }

    fun top(): Int {
        return totalStack[totalStack.size - 1]
    }

    fun getMin(): Int {
        return trackMinStack[trackMinStack.size - 1].value
    }
}

data class MinStackNode(val value: Int, var count: Int = 1)

package boj1967

class Node {
    val children = ArrayList<Int>()

    fun addChild(childIdx: Int) {
        children.add(childIdx)
    }
}

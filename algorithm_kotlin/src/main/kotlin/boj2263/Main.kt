package boj2263

class TreeNode(private val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    fun buildPreOrder(sb: StringBuilder) {
        sb.append(value).append(' ')
        left?.buildPreOrder(sb)
        right?.buildPreOrder(sb)
    }
}

var inOrderIndexMap = emptyMap<Int, Int>()
var postOrder = emptyList<Int>()
var nextPostOrderIndex = 0

fun buildTree(inOrderFrom: Int, inOrderTo: Int): TreeNode {
    val rootValue = postOrder[nextPostOrderIndex--]
    val root = TreeNode(rootValue)
    val rootInOrderIndex = inOrderIndexMap[rootValue]!!
    val leftSize = rootInOrderIndex - inOrderFrom
    val rightSize = inOrderTo - rootInOrderIndex - 1

    if (rightSize > 0) {
        root.right = buildTree(rootInOrderIndex + 1, inOrderTo)
    }
    if (leftSize > 0) {
        root.left = buildTree(inOrderFrom, rootInOrderIndex)
    }

    return root
}

fun main() {
    val n = readln().toInt()
    nextPostOrderIndex = n - 1
    inOrderIndexMap = readln().split(" ").mapIndexed { i, s -> s.toInt() to i }.toMap()
    postOrder = readln().split(" ").map { x -> x.toInt() }

    val root = buildTree(0, n)

    val result = StringBuilder()
    root.buildPreOrder(result)
    println(result.toString())
}
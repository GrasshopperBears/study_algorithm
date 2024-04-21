package leet173

class BSTIterator(root: TreeNode?) {
    private var idx = 0
    private val nodes = mutableListOf<TreeNode>()

    init {
        traverse(root)
    }

    fun next(): Int {
        val next = nodes[idx]
        idx += 1
        return next.`val`
    }

    fun hasNext(): Boolean {
        return idx < nodes.size
    }

    private fun traverse(node: TreeNode?) {
        if (node == null) {
            return
        }
        traverse(node.left)
        nodes.add(node)
        traverse(node.right)
    }
}

data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

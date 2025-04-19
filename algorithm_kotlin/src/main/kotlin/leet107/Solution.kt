package leet107

class Solution {
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        val bfs = mutableListOf(listOf(root.`val`))
        var level = listOf(root)
        while (true) {
            val nextBfs = mutableListOf<TreeNode>()
            for (node in level) {
                node.left?.let { nextBfs.add(it) }
                node.right?.let { nextBfs.add(it) }
            }
            if (nextBfs.isEmpty()) break
            bfs.add(nextBfs.map { it.`val` })
            level = nextBfs
        }
        bfs.reverse()
        return bfs
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

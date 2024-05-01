package leet314

data class Next(
    val node: TreeNode,
    val vi: Int
)

class Solution {
    private var minVi = 0
    private var maxVi = 0
    private val q = mutableListOf<Next>()
    private val map = mutableMapOf<Int, MutableList<Int>>()

    private fun convertResult(): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        for (i in minVi..maxVi) {
            map[i]?.let {
                result.add(it)
            }
        }
        return result
    }

    fun verticalOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return emptyList()
        }
        q.add(Next(root, 0))

        while (q.size > 0) {
            val (node, vi) = q.removeFirst()

            if (vi < minVi) minVi = vi
            if (vi > maxVi) maxVi = vi

            if (map.containsKey(vi)) {
                map[vi]!!.add(node.`val`)
            } else {
                map[vi] = mutableListOf(node.`val`)
            }
            node.left?.let {
                q.add(Next(it, vi-1))
            }
            node.right?.let {
                q.add(Next(it, vi+1))
            }
        }
        return convertResult()
    }
}

data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

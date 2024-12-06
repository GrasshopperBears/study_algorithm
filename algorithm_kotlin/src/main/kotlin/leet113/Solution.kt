package leet113

class Solution {
    private val answer = mutableListOf<List<Int>>()
    private var target = 0
    private val status = Status(0, mutableListOf())

    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        target = targetSum
        if (root == null) {
            return listOf()
        }
        dfs(root)
        return answer
    }

    private fun dfs(node: TreeNode) {
        if (node.left == null && node.right == null) {
            if (status.sum + node.`val` == target) {
                answer.add(status.nodeValues + node.`val`)
            }
            return
        }

        status.sum += node.`val`
        status.nodeValues.add(node.`val`)
        if (node.left != null) {
            dfs(node.left!!)
        }
        if (node.right != null) {
            dfs(node.right!!)
        }
        status.sum -= node.`val`
        status.nodeValues.removeLast()
    }
}

data class Status(var sum: Int, val nodeValues: MutableList<Int>)

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

package leet113

import boj14940.targetCol

class Solution {
    private val answer = mutableListOf<List<Int>>()
    private var target = 0

    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        target = targetSum
        if (root == null) {
            return listOf()
        }
        dfs(root, Status(0, mutableListOf()))
        return answer
    }

    private fun dfs(node: TreeNode, status: Status) {
        if (node.left == null && node.right == null) {
            if (status.sum + node.`val` == target) {
                answer.add(status.nodeValues + node.`val`)
            }
            return
        }

        status.sum += node.`val`
        status.nodeValues.add(node.`val`)
        if (node.left != null) {
            dfs(node.left!!, status)
        }
        if (node.right != null) {
            dfs(node.right!!, status)
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

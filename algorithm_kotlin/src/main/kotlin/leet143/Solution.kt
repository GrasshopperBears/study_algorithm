package leet143

class Solution {
    fun reorderList(head: ListNode?) {
        if (head?.next == null || head.next!!.next == null) return

        var fast: ListNode? = head
        var slow: ListNode? = head
        while (fast != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        var right: ListNode? = reverse(slow!!)
        var left: ListNode? = head
        while (left != null && right != null) {
            val nl = left.next
            val nr = right.next
            left.next = right
            right.next = if (nl == right) {
                null
            } else {
                nl
            }
            left = nl
            right = nr
        }
        if (left != null) {
            left.next = null
        }
    }

    private fun reverse(node: ListNode): ListNode {
        var prev: ListNode? = null
        var current: ListNode? = node
        while (current != null) {
            val n = current.next
            current.next = prev
            prev = current
            current = n
        }
        return prev!!
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

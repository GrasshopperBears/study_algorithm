package leet19

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var left = head
        var right: ListNode? = head

        for (i in 0 until n) {
            right = right?.next
        }

        if (right == null) {
            return head!!.next
        }
        while (right?.next != null) {
            left = left!!.next
            right = right.next
        }
        left!!.next = left.next?.next
        return head
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

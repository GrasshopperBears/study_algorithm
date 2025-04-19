package leet2095

class Solution {
    fun deleteMiddle(head: ListNode?): ListNode? {
        if (head?.next == null) return null

        var prev = head
        var slow = head
        var fast = head

        while (fast?.next != null) {
            prev = slow
            slow = slow!!.next
            fast = fast.next?.next
        }
        prev!!.next = slow!!.next

        return head
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
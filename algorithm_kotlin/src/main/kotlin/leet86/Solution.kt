package leet86

class Solution {
    fun partition(head: ListNode?, x: Int): ListNode? {
        val preHead = ListNode(-101).apply {
            this.next = head
        }

        var currLess = preHead
        var ptr: ListNode? = currLess

        while (ptr?.next != null && ptr.next!!.`val` < x) {
            currLess = ptr.next!!
            ptr = ptr.next
        }
        while (ptr?.next != null) {
            while (ptr?.next != null && ptr?.next!!.`val` >= x) {
                ptr = ptr?.next
            }
            if (ptr?.next == null) {
                break
            }
            val target = ptr!!.next!!

            ptr.next = target.next
            target.next = currLess.next
            currLess.next = target
            currLess = target
        }

        return preHead.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


/**
 * class Solution {
 *     fun partition(head: ListNode?, x: Int): ListNode? {
 *         val lessDummy = ListNode(0)
 *         val greaterDummy = ListNode(0)
 *         var less = lessDummy
 *         var greater = greaterDummy
 *         var current = head
 *
 *         while (current != null) {
 *             if (current.`val` < x) {
 *                 less.next = current
 *                 less = less.next!!
 *             } else {
 *                 greater.next = current
 *                 greater = greater.next!!
 *             }
 *             current = current.next
 *         }
 *
 *         // connect the end of the less list to the start of the greater list
 *         greater.next = null
 *         less.next = greaterDummy.next
 *         return lessDummy.next
 *     }
 * }
 */

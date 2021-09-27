const assert = require("assert");
const { LinkedList, ListNode } = require("./lib/LinkedList");

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
const sortList = (head) => {
  if (head === null || head.next === null) return head;

  const preHead = new ListNode(0, head);
  let left = preHead;
  let right = preHead;

  while (right !== null && right.next !== null) {
    left = left?.next;
    right = right?.next?.next;
  }
  const rightHead = left?.next;
  left.next = null;

  let ptr = preHead;
  const leftSorted = sortList(head);
  const rightSorted = sortList(rightHead);
  left = leftSorted;
  right = rightSorted;

  while (left !== null || right !== null) {
    if (left === null || (right !== null && left.val > right.val)) {
      ptr.next = right;
      ptr = right;
      right = right.next;
    } else {
      ptr.next = left;
      ptr = left;
      left = left.next;
    }
  }
  return preHead.next;
};

assert.deepEqual(LinkedList.toArray(sortList(new LinkedList([4, 2, 1, 3]).head)), [1, 2, 3, 4]);
assert.deepEqual(LinkedList.toArray(sortList(new LinkedList([-1, 5, 3, 4, 0]).head)), [-1, 0, 3, 4, 5]);
assert.deepEqual(LinkedList.toArray(sortList(new LinkedList([]).head)), []);

console.log("test passed");

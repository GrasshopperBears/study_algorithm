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
const assert = require("assert");
const { LinkedList } = require("./lib/LinkedList");

const swapPairs = (head) => {
  let prev = undefined;
  let left = head;
  let right = left?.next;
  let next = right?.next;
  let retVal = left?.val === undefined || right === null ? head : right;

  while (left?.val !== undefined && right?.val !== undefined) {
    if (prev !== undefined) prev.next = right;
    left.next = next;
    right.next = left;

    prev = left;
    left = next;
    right = next?.next;
    next = right?.next;
  }
  return retVal;
};

// assert.deepEqual(LinkedList.toArray(swapPairs(new LinkedList([1, 2, 3, 4]).head)), [2, 1, 4, 3]);
assert.deepEqual(LinkedList.toArray(swapPairs(new LinkedList([]).head)), []);
// assert.deepEqual(LinkedList.toArray(swapPairs(new LinkedList([1]).head)), [1]);
// assert.deepEqual(LinkedList.toArray(swapPairs(new LinkedList([0, 4, 9, 2]).head)), [4, 0, 2, 9]);
// assert.deepEqual(LinkedList.toArray(swapPairs(new LinkedList([4, 0, 6, 2, 8]).head)), [0, 4, 2, 6, 8]);

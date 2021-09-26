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
 * @param {number} k
 * @return {ListNode}
 */
const swapNodes = (head, k) => {
  let preSave = undefined;
  let save = undefined;
  const preHead = new ListNode(0, head);
  let preProbe = preHead;
  let probe = head;
  let preAhead = preProbe;
  let ahead = undefined;

  for (let i = 0; i < k - 1; i++) {
    preAhead = preAhead.next;
  }
  ahead = preAhead.next;

  let cnt = 1;
  while (ahead !== null && ahead.next !== null) {
    if (cnt++ === k) {
      preSave = preProbe;
      save = probe;
    }
    preProbe = preProbe.next;
    probe = probe.next;
    preAhead = preAhead.next;
    ahead = ahead.next;
  }
  if (!save) {
    const savePreProbe = preProbe;
    const saveProbe = probe;
    while (cnt++ < k) {
      preProbe = preProbe.next;
      probe = probe.next;
    }
    preSave = preProbe;
    save = probe;
    preProbe = savePreProbe;
    probe = saveProbe;
  }

  const saveNext = save?.next === probe ? save : save?.next;
  preSave.next = probe;
  save.next = probe?.next;
  probe.next = saveNext;
  if (preProbe !== save) preProbe.next = save;
  return preHead.next;
};

assert.deepEqual(LinkedList.toArray(swapNodes(new LinkedList([1]).head, 1)), [1]);
assert.deepEqual(LinkedList.toArray(swapNodes(new LinkedList([1, 2]).head, 1)), [2, 1]);
assert.deepEqual(LinkedList.toArray(swapNodes(new LinkedList([1, 2]).head, 2)), [2, 1]);
assert.deepEqual(LinkedList.toArray(swapNodes(new LinkedList([1, 2, 3]).head, 2)), [1, 2, 3]);
assert.deepEqual(LinkedList.toArray(swapNodes(new LinkedList([7, 9, 6, 6, 7, 8, 3, 0, 9, 5]).head, 3)), [7, 9, 0, 6, 7, 8, 3, 6, 9, 5]);
assert.deepEqual(LinkedList.toArray(swapNodes(new LinkedList([7, 9, 6, 6, 7, 8, 3, 0, 9, 5]).head, 5)), [7, 9, 6, 6, 8, 7, 3, 0, 9, 5]);

console.log("test all passed");

class ListNode {
  constructor(val = undefined, next = null) {
    this.val = val;
    this.next = next;
  }
}

class LinkedList {
  constructor(arr) {
    this.head = new ListNode(arr?.[0], arr?.[1]);
    let ptr = this.head;
    let idx = 1;

    while (ptr.next !== null) {
      ptr.next = new ListNode(arr?.[idx], arr?.[++idx]);
      ptr = ptr.next;
    }
  }

  static toArray(head) {
    const arr = new Array();
    let ptr = head;
    while (ptr?.val !== undefined) {
      arr.push(ptr.val);
      ptr = ptr.next;
    }
    return arr;
  }
}

module.exports = LinkedList;

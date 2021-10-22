const assert = require('assert');

class BookNode {
  constructor(start, end) {
    this.start = start;
    this.end = end;
    this.left = undefined;
    this.right = undefined;
  }

  insert(node) {
    if (node.start >= this.end) {
      if (!this.right) {
        this.right = node;
        return true;
      }
      return this.right.insert(node);
    } else if (node.end <= this.start) {
      if (!this.left) {
        this.left = node;
        return true;
      }
      return this.left.insert(node);
    }
    return false;
  }
}

class MyCalendar {
  constructor() {
    this.timeInterval = [];
    this.bookingTreeRoot = undefined;
  }

  /**
   * @param {number} start
   * @param {number} end
   * @return {boolean}
   */
  book(start, end) {
    if (this.bookingTreeRoot) return this.bookingTreeRoot.insert(new BookNode(start, end));
    this.bookingTreeRoot = new BookNode(start, end);
    return true;
  }
}

const calendar = new MyCalendar();
assert.deepEqual(calendar.book(10, 20), true);
assert.deepEqual(calendar.book(15, 20), false);
assert.deepEqual(calendar.book(20, 30), true);

console.log('All test passed');

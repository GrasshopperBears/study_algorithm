const assert = require('assert');

class FirstUnique {
  constructor(nums) {
    this.queue = nums;
    this.count = new Map();
    for (let num of nums) {
      const prev = this.count.get(num);
      this.count.set(num, prev ? prev + 1 : 1);
    }
  }

  showFirstUnique() {
    for (let num of this.queue) {
      if (this.count.get(num) === 1) return num;
    }
    return -1;
  }

  add(val) {
    this.queue.push(val);
    const prev = this.count.get(val);
    this.count.set(val, prev ? prev + 1 : 1);
  }
}

const queue1 = new FirstUnique([2, 3, 5]);
assert.deepEqual(queue1.showFirstUnique(), 2);
queue1.add(5);
assert.deepEqual(queue1.showFirstUnique(), 2);
queue1.add(2);
assert.deepEqual(queue1.showFirstUnique(), 3);
queue1.add(3);
assert.deepEqual(queue1.showFirstUnique(), -1);

const queue2 = new FirstUnique([7, 7, 7, 7, 7, 7]);
assert.deepEqual(queue2.showFirstUnique(), -1);
queue2.add(7);
queue2.add(3);
queue2.add(3);
queue2.add(3);
queue2.add(7);
queue2.add(17);
assert.deepEqual(queue2.showFirstUnique(), 17);

const queue3 = new FirstUnique([809]);
assert.deepEqual(queue3.showFirstUnique(), 809);
queue3.add(809);
assert.deepEqual(queue3.showFirstUnique(), -1);

console.log('All test passed');

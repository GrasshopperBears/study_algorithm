const assert = require('assert');

class RandomizedSet {
  constructor() {
    this.set = {};
  }
  insert(val) {
    if (this.set[val]) return false;

    this.set[val] = true;
    return true;
  }
  remove(val) {
    if (!this.set[val]) return false;

    delete this.set[val];
    return true;
  }
  getRandom() {
    const keys = Object.keys(this.set);
    const randomIdx = Math.floor(Math.random() * keys.length);

    return keys[randomIdx];
  }
}

// TEST CASE
const obj = new RandomizedSet();

assert.deepEqual(obj.insert(1), true);
assert.deepEqual(obj.insert(10), true);
assert.deepEqual(obj.insert(20), true);
assert.deepEqual(obj.insert(30), true);

assert.deepEqual(obj.insert(10), false);

console.log(obj.getRandom());
console.log(obj.getRandom());
console.log(obj.getRandom());
console.log(obj.getRandom());
console.log(obj.getRandom());
console.log(obj.getRandom());

assert.deepEqual(obj.remove(1), true);
assert.deepEqual(obj.remove(10), true);

assert.deepEqual(obj.remove(10), false);

console.log('All test passed');

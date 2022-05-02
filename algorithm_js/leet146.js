const assert = require('assert');

class Node {
  constructor(key = null, val = null) {
    this.key = key;
    this.val = val;
    this.next = null;
    this.prev = null;
  }
}

class LRUCache {
  constructor(capacity) {
    this.capacity = capacity;
    this.keyMap = new Map();
    this.head = new Node();
    this.tail = new Node();
    this.head.next = this.tail;
    this.tail.prev = this.head;
  }

  get(key) {
    const found = this.keyMap.get(key);
    if (found) {
      this.update(found);
      return found.val;
    }
    return -1;
  }

  put(key, value) {
    if (this.keyMap.has(key)) {
      const node = this.keyMap.get(key);
      node.val = value;

      return this.update(node);
    }
    if (this.capacity > 0) {
      const newNode = new Node(key, value);
      this.keyMap.set(key, newNode);
      newNode.next = this.head.next;
      this.head.next.prev = newNode;
      this.head.next = newNode;
      newNode.prev = this.head;
      this.capacity--;
      return;
    }
    const newNode = new Node(key, value);
    const deletingNode = this.tail.prev;
    deletingNode.prev.next = deletingNode.next;
    deletingNode.next.prev = deletingNode.prev;
    this.keyMap.delete(deletingNode.key);
    this.keyMap.set(key, newNode);
    this.update(newNode, false);
  }

  update(node, isUpdating = true) {
    if (node.prev == this.head) return;
    if (isUpdating) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }
    this.head.next.prev = node;
    node.next = this.head.next;
    node.prev = this.head;
    this.head.next = node;
  }
}

const lruCache1 = new LRUCache(2);

lruCache1.put(1, 1);
lruCache1.put(2, 2);
assert.deepEqual(lruCache1.get(1), 1);
lruCache1.put(3, 3);
assert.deepEqual(lruCache1.get(2), -1);
lruCache1.put(4, 4);
assert.deepEqual(lruCache1.get(1), -1);
assert.deepEqual(lruCache1.get(3), 3);
assert.deepEqual(lruCache1.get(4), 4);

const lruCache2 = new LRUCache(1);
lruCache2.put(2, 1);
assert.deepEqual(lruCache2.get(2), 1);
lruCache2.put(3, 2);
assert.deepEqual(lruCache2.get(2), -1);
assert.deepEqual(lruCache2.get(3), 2);

console.log('All test passed');

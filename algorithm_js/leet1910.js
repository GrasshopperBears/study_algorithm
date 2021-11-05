const assert = require('assert');

class Stack {
  constructor() {
    this.last = undefined;
    this.length = 0;
  }
  get string() {
    let ret = '';
    while (this.last) {
      ret = this.last.char + ret;
      this.last = this.last.prev;
    }
    return ret;
  }
  push(node) {
    this.length++;
    if (!this.last) this.last = node;
    else {
      node.prev = this.last;
      this.last = node;
    }
  }
  cut(node, size) {
    this.length -= size;
    this.last = node.prev;
  }
}

class Node {
  constructor(char) {
    this.char = char;
    this.prev = undefined;
  }
}

const removeOccurrences = (s, part) => {
  let stack = new Stack();

  for (let idx = 0; idx < s.length; idx++) {
    stack.push(new Node(s[idx]));
    if (stack.length >= part.length) {
      let ptr = stack.last;
      for (let i = part.length - 1; i >= 0; i--) {
        if (part[i] !== ptr.char) break;
        if (!i) stack.cut(ptr, part.length);
        else ptr = ptr.prev;
      }
    }
  }
  return stack.string;
};

assert.deepEqual(removeOccurrences('daabcbaabcbc', 'abc'), 'dab');
assert.deepEqual(removeOccurrences('axxxxyyyyb', 'xy'), 'ab');
assert.deepEqual(removeOccurrences('aabcbcc', 'abc'), 'c');
assert.deepEqual(removeOccurrences('rrrzokrrrzoktbgnlerpstimuatbgnlerpstimuagdgtmfy', 'rrrzoktbgnlerpstimua'), 'gdgtmfy');
assert.deepEqual(removeOccurrences('gjzgbpggjzgbpgsvpwdk', 'gjzgbpg'), 'svpwdk');
assert.deepEqual(
  removeOccurrences(
    'kpygkivtlqoockpygkivtlqoocssnextkqzjpycbylkaondsskpygkpygkivtlqoocssnextkqzjpkpygkivtlqoocssnextkqzjpycbylkaondsycbylkaondskivtlqoocssnextkqzjpycbylkaondssnextkqzjpycbylkaondshijzgaovndkjiiuwjtcpdpbkrfsi',
    'kpygkivtlqoocssnextkqzjpycbylkaonds'
  ),
  'hijzgaovndkjiiuwjtcpdpbkrfsi'
);
assert.deepEqual(
  removeOccurrences(
    'ifiacgaiifiacifiacgaiidbmhwxxlrhozywntgiqgaiidifiacgaiidbmhwxxlrhozywntgiqbifiacgaiidbmhwxxlrhozywntgiqifiacgaiidbmhwxifiacgaiidbmhwxxlrhozywntgiqxlrhozywntgiqmhwxxlrhozywntgiqidbmhwxxlrhozywifiacgaiidbmhwxxifiacgaiidbmhwxxlrhozywntgiqlrhozywntgiqntgiqjwifiacgaiidbmhwifiacgaiidbmhwxxlrhozywntgiqxxlrhoifiacgaiidbmhifiacgaiidbmhwxxlrhozywntgiqwxxlrhozywntgiqzywntgiqifiacgaiidbmhwxxlrhozywntgiqirayhgnqkrpuianmxm',
    'ifiacgaiidbmhwxxlrhozywntgiq'
  ),
  'jwirayhgnqkrpuianmxm'
);

console.log('All test passed');

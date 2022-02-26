const assert = require('assert');

const generateParenthesis = (n: number): string[] => {
  const result: string[] = [];

  const generator = (str: string, left: number, right: number) => {
    if (str.length === 2 * n) {
      result.push(str);
      return;
    }
    if (left < n) {
      str += '(';
      generator(str, left + 1, right);
      str = str.slice(0, str.length - 1);
    }
    if (right < left) {
      str += ')';
      generator(str, left, right + 1);
      str = str.slice(0, str.length - 1);
    }
  };
  generator('', 0, 0);
  return result;
};

assert.deepEqual(generateParenthesis(3), ['((()))', '(()())', '(())()', '()(())', '()()()']);
assert.deepEqual(generateParenthesis(1), ['()']);

console.log('All test passed');

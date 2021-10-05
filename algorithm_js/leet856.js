const assert = require("assert");

const scoreOfParentheses = (s) => {
  return scoreOfParenthesesV2(s);

  const stack = [0];

  for (let idx = 0; idx < s.length; idx++) {
    if (s[idx] === "(") {
      stack.push(0);
    } else {
      const recent = stack.pop();
      const last = stack.pop();
      stack.push(last + (recent ? recent * 2 : 1));
    }
  }
  return stack[0];
};

const scoreOfParenthesesV2 = (s) => {
  const stack = new Array(s.length / 2);
  stack[0] = 0;
  let stackIdx = 0;

  for (let idx = 0; idx < s.length; idx++) {
    if (s[idx] === "(") {
      stack[++stackIdx] = 0;
    } else {
      const recent = stack[stackIdx--];
      const last = stack[stackIdx--];
      stack[++stackIdx] = last + (recent ? recent * 2 : 1);
    }
  }
  return stack[stackIdx];
};

assert.deepEqual(scoreOfParentheses("()"), 1);
assert.deepEqual(scoreOfParentheses("(())"), 2);
assert.deepEqual(scoreOfParentheses("()()"), 2);
assert.deepEqual(scoreOfParentheses("(())()"), 3);
assert.deepEqual(scoreOfParentheses("(()(()))"), 6);

console.log("All test passed");

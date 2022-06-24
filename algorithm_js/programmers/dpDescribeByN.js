const assert = require('assert');

function solution(N, number) {
  let prev = [null, [-N, N]];
  let cnt = 1;
  let lastNRepeat = N;
  while (!prev[cnt].includes(number)) {
    const rpt = (lastNRepeat = 10 * lastNRepeat + N);
    const nextSet = new Set([-rpt, rpt]);
    let left = 1;
    while (left <= Math.floor((cnt + 1) / 2)) {
      const right = cnt + 1 - left;
      for (let i = 0; i < prev[left].length; i++) {
        const leftNum = prev[left][i];
        for (let j = 0; j < prev[right].length; j++) {
          const rightNum = prev[right][j];
          nextSet
            .add(leftNum + rightNum)
            .add(leftNum - rightNum)
            .add(rightNum - leftNum)
            .add(leftNum * rightNum)
            .add(Math.floor(leftNum / rightNum))
            .add(Math.floor(rightNum / leftNum));
        }
      }
      left++;
    }
    cnt++;
    if (cnt > 8) return -1;
    prev.push([...nextSet.values()]);
  }
  return cnt;
}

assert.deepEqual(solution(5, 12), 4);
assert.deepEqual(solution(2, 11), 3);
assert.deepEqual(solution(5, 31168), -1);

console.log('All test passed');

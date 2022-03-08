const assert = require('assert');

const largestNumber = (costs, target) => {
  const DIGITS = 9;
  const costMap = new Map();

  for (let i = 1; i <= DIGITS; i++) {
    const cost = costs[i - 1];
    const prevDigits = costMap.get(cost) ?? 0;
    costMap.set(cost, Math.max(prevDigits, i));
  }
  const costMapEntries = Array.from(costMap.entries()).sort((a, b) => a[0] - b[0]);
  const costMapKeys = costMapEntries.map(([key]) => key);

  const getMaxKeys = (target, index) => {
    let result = [];
    if (target <= 0) return result;

    const current = costMapKeys[index];

    for (let i = parseInt(target / current); i >= 0; i--) {
      const nextTarget = target - current * i;
      if (!nextTarget) {
        result.push([[index, i]]);
        return result;
      }

      const maxKeys = getMaxKeys(target - current * i, index + 1);
      if (maxKeys.length) {
        result.push(
          ...(i > 0
            ? maxKeys.reduce((acc, curr) => {
                acc.push([[index, i], ...curr]);
                return acc;
              }, [])
            : maxKeys)
        );
      }
    }
    return result;
  };

  const numCountMap = getMaxKeys(target, 0).map((maxKey) =>
    maxKey.map(([index, count]) => [costMapEntries[index][1], count]).sort((a, b) => b[0] - a[0])
  );

  let currentMax = '0';

  for (let numCount of numCountMap) {
    const number = numCount.reduce((acc, [num, count]) => {
      for (let i = 0; i < count; i++) acc += num.toString();
      return acc;
    }, '');
    if (Number(number) > Number(currentMax)) currentMax = number;
  }
  return currentMax;
};

assert.deepEqual(largestNumber([4, 3, 2, 5, 6, 7, 2, 5, 5], 9), '7772');
assert.deepEqual(largestNumber([7, 6, 5, 5, 5, 6, 8, 7, 8], 12), '85');
assert.deepEqual(largestNumber([2, 4, 6, 2, 4, 6, 4, 4, 4], 5), '0');
assert.deepEqual(largestNumber([5, 6, 7, 3, 4, 6, 7, 4, 8], 29), '884444444');
assert.deepEqual(largestNumber([2, 4, 2, 5, 3, 2, 5, 5, 4], 739), ''); // heap out of memory

console.log('All test passed');

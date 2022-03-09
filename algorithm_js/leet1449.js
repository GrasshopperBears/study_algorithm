const assert = require('assert');

const largestNumber = (costs, target) => {
  const DIGITS = 9;
  const costTargetMap = new Array(target + 1).fill(-1);
  costTargetMap[0] = 0;

  for (let currentTarget = 1; currentTarget <= target; currentTarget++) {
    for (let i = 0; i < DIGITS; i++) {
      const currentCost = costs[i];
      if (currentTarget >= currentCost) {
        const max = Math.max(costTargetMap[currentTarget], costTargetMap[currentTarget - currentCost] + 1);
        if (max > 0) costTargetMap[currentTarget] = max;
      }
    }
  }

  if (costTargetMap[target] < 0) return '0';

  let result = '';

  for (let i = DIGITS - 1; i >= 0; i--) {
    const currentCost = costs[i];
    while (target >= currentCost && costTargetMap[target] - costTargetMap[target - currentCost] === 1) {
      result += (i + 1).toString();
      target -= currentCost;
    }
  }
  return result;
};

assert.deepEqual(largestNumber([4, 3, 2, 5, 6, 7, 2, 5, 5], 9), '7772');
assert.deepEqual(largestNumber([7, 6, 5, 5, 5, 6, 8, 7, 8], 12), '85');
assert.deepEqual(largestNumber([2, 4, 6, 2, 4, 6, 4, 4, 4], 5), '0');
assert.deepEqual(largestNumber([5, 6, 7, 3, 4, 6, 7, 4, 8], 29), '884444444');
assert.deepEqual(
  largestNumber([2, 4, 2, 5, 3, 2, 5, 5, 4], 739),
  '666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666665'
); // heap out of memory

console.log('All test passed');

const assert = require('assert');

const permuteUnique = (nums) => {
  const countMap = new Map();
  const result = [];

  for (let num of nums) {
    const currentCount = countMap.get(num);
    countMap.set(num, currentCount ? currentCount + 1 : 1);
  }

  const permutate = (currentList, map) => {
    if (currentList.length === nums.length) {
      result.push(currentList);
      return;
    }
    for (let [key, val] of map.entries()) {
      if (val === 0) continue;
      const nextList = [...currentList, key];
      const prevVal = val;

      map.set(key, prevVal - 1);
      permutate(nextList, map);
      map.set(key, prevVal);
    }
  };
  permutate([], countMap);
  return result;
};

assert.deepEqual(permuteUnique([1, 1, 2]), [
  [1, 1, 2],
  [1, 2, 1],
  [2, 1, 1],
]);
assert.deepEqual(permuteUnique([1, 2, 3]), [
  [1, 2, 3],
  [1, 3, 2],
  [2, 1, 3],
  [2, 3, 1],
  [3, 1, 2],
  [3, 2, 1],
]);

console.log('All test passed');

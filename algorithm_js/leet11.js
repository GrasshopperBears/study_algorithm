const assert = require('assert');

const maxArea = (heights) => {
  const heightMap = new Map();

  for (let i = 0; i < heights.length; i++) {
    const height = heights[i];
    if (!height) continue;
    const prevList = heightMap.get(height);
    heightMap.set(height, prevList ? [...prevList, i] : [i]);
  }

  const heightKeys = [...heightMap.keys()];
  heightKeys.sort((a, b) => b - a);

  let min = -1,
    max = -1,
    result = 0;
  for (let currentHeight of heightKeys) {
    const indices = heightMap.get(currentHeight);
    const first = indices[0];
    const last = indices[indices.length - 1];
    if (min < 0 || first < min) min = first;
    if (max < 0 || last > max) max = last;
    result = Math.max(result, currentHeight * (max - min));
  }
  return result;
};

assert.deepEqual(maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]), 49);
assert.deepEqual(maxArea([1, 1]), 1);

console.log('All test passed');

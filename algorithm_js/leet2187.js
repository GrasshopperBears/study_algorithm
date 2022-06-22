const assert = require('assert');

const minimumTime = (time, totalTrips) => {
  let left = 1,
    right = Math.max(...time) * totalTrips,
    minTime = right;
  while (left <= right) {
    const mid = Math.floor((left + right) / 2);
    const current = time.reduce((acc, bus) => acc + Math.floor(mid / bus), 0);

    if (current >= totalTrips) {
      right = mid - 1;
      minTime = mid;
    } else left = mid + 1;
  }
  return minTime;
};

assert.deepEqual(minimumTime([1, 2, 3], 5), 3);
assert.deepEqual(minimumTime([2], 1), 2);
assert.deepEqual(minimumTime([5, 10, 10], 9), 25);

console.log('All test passed');

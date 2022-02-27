const assert = require('assert');

const corpFlightBookings = (bookings: number[][], n: number): number[] => {
  const answer = new Array(n + 1).fill(0);

  for (const [from, to, amount] of bookings) {
    answer[from] += amount;
    if (to < n) answer[to + 1] -= amount;
  }
  return answer.slice(1).reduce((acc, curr, index) => {
    if (index) acc.push(acc[index - 1] + curr);
    else acc.push(curr);

    return acc;
  }, []);
};

assert.deepEqual(
  corpFlightBookings(
    [
      [1, 2, 10],
      [2, 3, 20],
      [2, 5, 25],
    ],
    5
  ),
  [10, 55, 45, 25, 25]
);
assert.deepEqual(
  corpFlightBookings(
    [
      [1, 2, 10],
      [2, 2, 15],
    ],
    2
  ),
  [10, 25]
);

console.log('All test passed');

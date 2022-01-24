const assert = require('assert');

const sortByArr1 = (arr1, arr2) => {
  if (arr1.length <= 1) return [arr1, arr2];

  const pivot = arr1[0];
  const { lesser1, lesser2, greater1, greater2 } = arr1.reduce(
    (acc, el1, idx1) => {
      if (idx1 === 0) return acc;
      if (el1 > pivot || (el1 === pivot && arr2[idx1] >= arr2[0])) {
        acc.greater1.push(el1);
        acc.greater2.push(arr2[idx1]);
      } else {
        acc.lesser1.push(el1);
        acc.lesser2.push(arr2[idx1]);
      }
      return acc;
    },
    { lesser1: [], lesser2: [], greater1: [], greater2: [] }
  );
  const [sortedLesser1, sortedLesser2] = sortByArr1(lesser1, lesser2);
  const [sortedGreater1, sortedGreater2] = sortByArr1(greater1, greater2);
  return [
    [...sortedLesser1, pivot, ...sortedGreater1],
    [...sortedLesser2, arr2[0], ...sortedGreater2],
  ];
};

const bestTeamScore = (scores, ages) => {
  const [sortedAges, sortedScores] = sortByArr1(ages, scores);
  const currMax = sortedScores.slice();

  // https://www.javatpoint.com/maximum-sum-increasing-subsequence
  for (let i = 0; i < sortedScores.length; i++) {
    for (let j = 0; j < i; j++) {
      if (sortedScores[i] >= sortedScores[j] || sortedAges[i] === sortedAges[j]) {
        currMax[i] = Math.max(currMax[i], currMax[j] + sortedScores[i]);
      }
    }
  }
  return Math.max(...currMax);
};

assert.deepEqual(bestTeamScore([4, 5, 6, 5], [2, 1, 2, 1]), 16);
assert.deepEqual(bestTeamScore([1, 3, 5, 10, 15], [1, 2, 3, 4, 5]), 34);
assert.deepEqual(bestTeamScore([1, 2, 3, 5], [8, 9, 10, 1]), 6);
assert.deepEqual(
  bestTeamScore([319776, 611683, 835240, 602298, 430007, 574, 142444, 858606, 734364, 896074], [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]),
  5431066
);
assert.deepEqual(bestTeamScore([1, 3, 7, 3, 2, 4, 10, 7, 5], [4, 5, 2, 1, 1, 2, 4, 1, 4]), 29);

console.log('All test passed');

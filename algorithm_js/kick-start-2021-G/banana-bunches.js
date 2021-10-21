const fs = require('fs');

// const input = fs.readFileSync('.\\input.txt').toString().split('\r\n');
// const caseNum = parseInt(input[0]);
const caseNum = 1;

for (let i = 1; i <= caseNum; i++) {
  // const [treeNum, target] = input[2 * i - 1].split(' ').map((numStr) => parseInt(numStr));
  // const trees = input[2 * i].split(' ').map((numStr) => parseInt(numStr));
  const treeNum = 6;
  const target = 8;
  const trees = [1, 2, 3, 1, 2, 3];

  const costsArr = new Array(treeNum).fill(0).reduce((acc) => {
    acc.push(new Array(target + 1));
    return acc;
  }, []);

  for (let currentTarget = 0; currentTarget <= target; currentTarget++) {
    for (let treeIdx = treeNum - 1; treeIdx >= 0; treeIdx--) {
      if (!currentTarget) {
        costsArr[treeIdx][currentTarget] = 0;
        continue;
      }
      if (trees[treeIdx] === currentTarget) {
        costsArr[treeIdx][currentTarget] = 1;
        console.log(treeIdx, currentTarget, 1);
        continue;
      }
      let currentMin = costsArr?.[treeIdx + 1]?.[currentTarget] ?? 51;

      if (currentTarget > 0 && treeIdx < trees.length - 2) {
        const dpVal = costsArr[treeIdx + 2][currentTarget - 1];
        // console.log('one', treeIdx, currentTarget, dpVal);
        if (dpVal >= 0 && trees[treeIdx] <= currentTarget && 1 + dpVal < currentMin) currentMin = 1 + dpVal;
      }
      if (currentTarget > 1 && treeIdx < trees.length - 3) {
        const dpVal = costsArr[treeIdx + 3][currentTarget - 2];
        if (dpVal >= 0 && trees[treeIdx] + trees[treeIdx + 1] <= currentTarget && 2 + dpVal < currentMin) currentMin = 2 + dpVal;
      }
      costsArr[treeIdx][currentTarget] = currentMin === 51 ? -1 : currentMin;
      console.log(treeIdx, currentTarget, currentMin);
    }
  }
  console.log(costsArr);

  console.log(`Case #${i}: ${costsArr[0][target]}`);
}

const fs = require('fs');

const input = fs.readFileSync('.\\input.txt').toString().split('\r\n');
const caseNum = parseInt(input[0]);

for (let i = 1; i <= caseNum; i++) {
  let [N, D, C, M] = input[2 * i - 1].split(' ').map((numStr) => parseInt(numStr));
  const animals = input[2 * i];
  let pos = -1;

  for (let animalIdx in animals) {
    const animal = animals[animalIdx];
    if (animal === 'D') {
      if (D <= 0) {
        pos = animalIdx;
        break;
      }
      D--;
      C += M;
    } else {
      if (C <= 0) {
        pos = animalIdx;
        break;
      }
      C -= 1;
    }
  }
  if (pos >= 0) {
    let j = pos;
    for (; j < animals.length; j++) {
      if (animals[j] === 'D') break;
    }
    if (j === animals.length) pos = -1;
  }

  console.log(`Case #${i}: ${pos < 0 ? 'YES' : 'NO'}`);
}

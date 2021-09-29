const assert = require("assert");

const mulDiv = (preVal, str, isMul) => {
  if (isMul) return preVal * Number(str);
  else {
    preVal /= Number(str);
    return Math.floor(preVal);
  }
};

const calcToken = (str) => {
  let parseTry = Number(str.trim());
  if (!isNaN(parseTry)) return parseTry;

  const mulDivReg = /[*\/]/g;
  let idx = str.search(mulDivReg);
  let preIdx = idx + 1;
  let isMul = str[idx] === "*";
  let result = Number(str.slice(0, idx).trim());

  while ((idx = str.slice(preIdx).search(mulDivReg)) > 0) {
    result = mulDiv(result, str.slice(preIdx, preIdx + idx).trim(), isMul);
    if (result === 0) return result;
    isMul = str[preIdx + idx] === "*";
    preIdx += idx + 1;
  }
  return mulDiv(result, str.slice(preIdx).trim(), isMul);
};

const calculate = (str) => {
  const addSubReg = /[+-]/g;
  let idx = 0;
  let preIdx = idx;
  let isAdd = true;
  let result = 0;

  while ((idx = str.slice(preIdx).search(addSubReg)) > 0) {
    if (isAdd) result += calcToken(str.slice(preIdx, preIdx + idx).trim());
    else result -= calcToken(str.slice(preIdx, preIdx + idx).trim());

    isAdd = str[preIdx + idx] === "+";
    preIdx += idx + 1;
  }
  if (isAdd) return result + calcToken(str.slice(preIdx).trim());
  else return result - calcToken(str.slice(preIdx).trim());
};

assert.deepEqual(calculate("3+2*2"), 7);
assert.deepEqual(calculate(" 3/2 "), 1);
assert.deepEqual(calculate(" 3+5 / 2 "), 5);
assert.deepEqual(calculate("1+1+1"), 3);
assert.deepEqual(calculate("1+1-1"), 1);
assert.deepEqual(calculate("2*3*4"), 24);

console.log("all test passed");

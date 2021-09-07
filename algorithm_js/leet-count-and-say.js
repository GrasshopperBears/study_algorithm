const helper = (number, n) => {
  if (n === 1) return number;
  let nextNumber = "";
  let current = "";
  let count = 0;
  for (let char of number) {
    if (char === current) {
      count++;
      continue;
    }
    if (count > 0) nextNumber += `${count}${current}`;
    current = char;
    count = 1;
  }
  nextNumber += `${count}${current}`;
  return helper(nextNumber, n - 1);
};

const countAndSay = (n) => {
  return helper("1", n);
};

console.log(countAndSay(5));

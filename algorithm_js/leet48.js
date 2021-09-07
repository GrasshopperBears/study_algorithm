const rotate = (matrix) => {
  const n = matrix.length;

  for (let i = 0; i < Math.floor(n / 2); i++) {
    for (let j = 0; j < n - 1; j++) {
      const numbers = [matrix[i][i+j], matrix[n-i-1][i+j], matrix[n]];
    }
  }
};

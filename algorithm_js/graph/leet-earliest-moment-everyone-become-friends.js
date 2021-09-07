class Graph {
  constructor(size) {
    this.root = new Array(size).fill(0).reduce((acc, _, idx) => {
      acc.push(idx);
      return acc;
    }, []);
    this.height = new Array(size).fill(1);
    this.count = size;
  }

  find(v) {
    if (this.root[v] === v) return v;
    this.root[v] = this.find(this.root[v]);
    return this.root[v];
  }

  union(x, y) {
    const rootX = this.find(x);
    const rootY = this.find(y);
    if (rootX === rootY) return;
    if (this.height[rootX] > this.height[rootY]) {
      this.root[rootY] = rootX;
    } else if (this.height[rootX] < this.height[rootY]) {
      this.root[rootX] = rootY;
    } else {
      this.root[rootY] = rootX;
      this.height[rootX] += 1;
    }
    this.count--;
  }
}

const compareLog = (a, b) => {
  return a[0] <= b[0] ? -1 : 1;
};

const earliestAcq = (logs, n) => {
  const graph = new Graph(n);
  logs.sort(compareLog);
  for (let log of logs) {
    graph.union(log[1], log[2]);
    if (graph.count === 1) return log[0];
  }
  return -1;
};

console.log(
  earliestAcq(
    [
      [20190101, 0, 1],
      [20190104, 3, 4],
      [20190107, 2, 3],
      [20190211, 1, 5],
      [20190224, 2, 4],
      [20190301, 0, 3],
      [20190312, 1, 2],
      [20190322, 4, 5],
    ],
    6
  )
);

console.log(
  earliestAcq(
    [
      [0, 2, 0],
      [1, 0, 1],
      [3, 0, 3],
      [4, 1, 2],
      [7, 3, 1],
    ],
    4
  )
);

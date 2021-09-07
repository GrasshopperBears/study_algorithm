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

  checkNoCycle() {
    return this.count === 1;
  }
}

const validTree = (n, edges) => {
  const graph = new Graph(n);

  if (edges.length !== n - 1) return false;
  for (let edge of edges) {
    const [x, y] = edge;
    graph.union(x, y);
  }
  return graph.checkNoCycle();
};

console.log(
  validTree(5, [
    [0, 1],
    [0, 2],
    [0, 3],
    [1, 4],
  ])
);
console.log(
  validTree(5, [
    [0, 1],
    [1, 2],
    [2, 3],
    [1, 3],
    [1, 4],
  ])
);

const assert = require('assert');

const findOrder = (numCourses, prerequisites) => {
  const UNVISITED = 0,
    VISITING = 1,
    VISITED = 2;
  const result = [];
  const visitStatus = Array(numCourses).fill(UNVISITED);
  const graph = Array(numCourses)
    .fill(false)
    .map(() => Array(numCourses).fill(false));

  for (const [next, prev] of prerequisites) {
    graph[prev][next] = true;
  }

  const visit = (course) => {
    if (visitStatus[course] === VISITING) return false;
    if (visitStatus[course] === VISITED) return true;
    visitStatus[course] = VISITING;
    const nextList = graph[course].reduce((acc, hasEdge, idx) => {
      if (hasEdge) acc.push(idx);
      return acc;
    }, []);
    for (let next of nextList) {
      if (!visit(next)) return false;
    }
    visitStatus[course] = VISITED;
    result.push(course);
    return true;
  };

  for (let i = 0; i < numCourses; i++) {
    if (!visit(i)) return [];
  }

  return result.reverse();
};

assert.deepEqual(findOrder(2, [[1, 0]]), [0, 1]);
assert.deepEqual(
  findOrder(2, [
    [0, 1],
    [1, 0],
  ]),
  []
);
assert.deepEqual(
  findOrder(4, [
    [1, 0],
    [2, 0],
    [3, 1],
    [3, 2],
  ]),
  [0, 2, 1, 3]
);

console.log('All test passed');

DIRECTIONS = [
  [-1, 0],
  [0, 1],
  [1, 0],
  [0, -1]
]

def hasPath(maze, start, destination):
  rows = len(maze)
  cols = len(maze[0])
  visited = [[False for _ in range(cols)] for _ in range(rows)]
  queue = [start]
  
  def findNext(pos, direction):
    curr_row = pos[0]
    curr_col = pos[1]
    row_dir = direction[0]
    col_dir = direction[1]
    
    while curr_row + row_dir >= 0 and curr_row + row_dir < rows and curr_col + col_dir >= 0 and curr_col + col_dir < cols:
      if maze[curr_row + row_dir][curr_col + col_dir] == 1:
        break
      curr_row += row_dir
      curr_col += col_dir
    
    return [curr_row, curr_col]
  
  while len(queue) > 0:
    [row, col]  = queue.pop(0)
    if visited[row][col]:
      continue
    if row == destination[0] and col == destination[1]:
      return True
    
    visited[row][col] = True
    for direction in DIRECTIONS:
      next = findNext([row, col], direction)
      if next[0] != row or next[1] != col:
        queue.append(next)
  
  return False

print(hasPath(
  [
    [0,0,1,0,0],
    [0,0,0,0,0],
    [0,0,0,1,0],
    [1,1,0,1,1],
    [0,0,0,0,0]
  ],
  [0,4],
  [4,4]
)) # True

print(hasPath(
  [
    [0,0,1,0,0],
    [0,0,0,0,0],
    [0,0,0,1,0],
    [1,1,0,1,1],
    [0,0,0,0,0]
  ],
  [0,4],
  [3,2]
)) # False

print(hasPath(
  [
    [0,0,0,0,0],
    [1,1,0,0,1],
    [0,0,0,0,0],
    [0,1,0,0,1],
    [0,1,0,0,0]
  ],
  [4,3],
  [0,1]
)) # False

print(hasPath(
      [
        [0,0,0,0,1,0,0],
        [0,0,1,0,0,0,0],
        [0,0,0,0,0,0,0],
        [0,0,0,0,0,0,1],
        [0,1,0,0,0,0,0],
        [0,0,0,1,0,0,0],
        [0,0,0,0,0,0,0],
        [0,0,1,0,0,0,1],
        [0,0,0,0,1,0,0]
      ],
      [0,0],
      [8,6]
)) # True

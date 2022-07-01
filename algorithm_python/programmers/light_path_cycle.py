def solution(grid):
    rows = len(grid)
    cols = len(grid[0])
    answer = []
    checked = [[[False for _ in range(4)] for _ in range(cols)] for _ in range(rows)]
    
    def findNext():
        nonlocal checked
        for i in range(len(checked)):
            for j in range(len(checked[0])):
                for k in range(len(checked[0][0])):
                    if not checked[i][j][k]:
                        checked[i][j][k] = True
                        return i, j, k
        return None
    
    def getNext(r, c, direction):
        node = grid[r][c]
        if node == 'S':
            if direction % 2 == 0:
                return (r + (1 if direction == 0 else -1), c, direction)
            return (r, c + (1 if direction == 3 else -1), direction)
        if node == 'L':
            if direction % 2 == 0:
                return (r, c + (1 if direction == 0 else -1), direction+3)
            return (r + (1 if direction == 1 else -1), c, direction+3)
        if node == 'R':
            if direction % 2 == 0:
                return (r, c + (-1 if direction == 0 else 1), direction+1)
            return (r + (-1 if direction == 1 else 1), c, direction+1)
        
    
    while True:
        nxt = findNext()
        if nxt == None: break
        startR, startC, direction = nxt
        i, j = startR, startC
        cnt = 1
        while True:
            nextR, nextC, nextDirection = getNext(i, j, direction)
            nextR = (nextR+rows)%rows
            nextC = (nextC+cols)%cols
            nextDirection = nextDirection % 4
            if checked[nextR][nextC][nextDirection]: break
            checked[nextR][nextC][nextDirection] = True
            cnt += 1
            i, j, direction = nextR, nextC, nextDirection
            
        answer.append(cnt)

    answer.sort()
    return answer

print(solution(["SL","LR"]))
print(solution(["S"]))
print(solution(["R","R"]))

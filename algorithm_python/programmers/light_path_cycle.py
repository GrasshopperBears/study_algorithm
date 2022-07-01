def solution(grid):
    rows = len(grid)
    cols = len(grid[0])
    answer = []
    checked = set()
    for i in range(rows):
        for j in range(cols):
            for k in range(4):
                checked.add((i, j, k))
    
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
        if len(checked) == 0: break
        nxt = checked.pop()
        startR, startC, direction = nxt
        i, j = startR, startC
        cnt = 1
        while True:
            nextR, nextC, nextDirection = getNext(i, j, direction)
            nextR = (nextR+rows)%rows
            nextC = (nextC+cols)%cols
            nextDirection = nextDirection % 4
            if (nextR, nextC, nextDirection) not in checked:
                break
            checked.discard((nextR, nextC, nextDirection))
            cnt += 1
            i, j, direction = nextR, nextC, nextDirection
            
        answer.append(cnt)

    answer.sort()
    return answer

print(solution(["SL","LR"]))
print(solution(["S"]))
print(solution(["R","R"]))

def rotate90(arr):
    rotated = []
    
    for block in arr:
        rotatedSet = set()
        shiftR, shiftC = 0, 0
        for r, c in block:
            rotatedSet.add((c, -r))
            if c < shiftR or (c == shiftR and -r < shiftC):
                shiftR, shiftC = c, -r
                
        if shiftR == 0 and shiftC == 0:
            rotated.append(rotatedSet)
        else:
            roateAndShift = set()
            for r, c in rotatedSet:
                roateAndShift.add((r-shiftR, c-shiftC))
            rotated.append(roateAndShift)
    
    return rotated


def extract(arr, extractEmpty):
    dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    n = len(arr)
    empties = []
    visited = [[False for _ in range(n)] for _ in range(n)]
    
    def bfs(r, c, baseR, baseC):
        visited[r][c] = True
        currSet = set([(r-baseR, c-baseC)])
        for dirR, dirC in dirs:
            nextR, nextC = r+dirR, c+dirC
            if nextR < 0 or nextC < 0 or nextR >= n or nextC >= n or visited[nextR][nextC]: continue
            if arr[nextR][nextC] == (1 if extractEmpty else 0): continue
            currSet |= bfs(nextR, nextC, baseR, baseC)
        return currSet

    for i in range(n):
        for j in range(n):
            if arr[i][j] == (0 if extractEmpty else 1) and not visited[i][j]:
                empties.append(bfs(i, j, i, j))
    
    return empties


def solution(game_board, table):
    empties = extract(game_board, True)
    blocks = extract(table, False)
    answer = 0
    
    for _ in range(4):
        emptyIdx = 0
        while emptyIdx < len(empties):
            fit = False
            for i, block in enumerate(blocks):
                empty = empties[emptyIdx]
                if len(block) == len(empty) and block == empty:
                    answer += len(block)
                    empties.pop(emptyIdx)
                    blocks.pop(i)
                    fit = True
                    break
            if not fit:
                emptyIdx += 1
        blocks = rotate90(blocks)


    return answer


print(solution([
        [1, 1, 0, 0, 1, 0],
        [0, 0, 1, 0, 1, 0],
        [0, 1, 1, 0, 0, 1],
        [1, 1, 0, 1, 1, 1],
        [1, 0, 0, 0, 1, 0],
        [0, 1, 1, 1, 0, 0]
    ], [
        [1, 0, 0, 1, 1, 0],
        [1, 0, 1, 0, 1, 0],
        [0, 1, 1, 0, 1, 1],
        [0, 0, 1, 0, 0, 0],
        [1, 1, 0, 1, 1, 0],
        [0, 1, 0, 0, 0, 0]
    ]
))  # 14

print(solution(
    [
        [0, 0, 0],
        [1, 1, 0],
        [1, 1, 1]
    ], [
        [1, 1, 1],
        [1, 0, 0],
        [0, 0, 0]
    ]
))  # 0

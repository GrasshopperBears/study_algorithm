from collections import deque


def solution(rectangle, characterX, characterY, itemX, itemY):
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    for i, r in enumerate(rectangle):
        for j, v in enumerate(r):
            rectangle[i][j] = 2 * v
    
    characterX *= 2
    characterY *= 2
    itemX *= 2
    itemY *= 2
    
    visited = [[False for _ in range(101)] for _ in range(101)]
    answer = float('inf')
    q = deque()
    q.append((characterX, characterY, 0))
    
    def isOnBorder(x, y):
        result = False
        
        for rect in rectangle:
            x1, y1, x2, y2 = rect
            if x > x1 and x < x2 and y > y1 and y < y2:
                return False
            if ((x == x1 or x == x2) and y >= y1 and y <= y2) or ((y == y1 or y == y2) and x >= x1 and x <= x2):
                result = True
        
        return result
    
    while len(q) > 0:
        x, y, cost = q.popleft()
        if x == itemX and y == itemY and cost < answer:
            answer= cost
            continue
        if visited[x][y]:
            continue
        visited[x][y] = True
        for dirX, dirY in directions:
            nextX = x + dirX
            nextY = y + dirY
            if not isOnBorder(nextX, nextY):
                continue
            q.append((x + 2*dirX, y + 2*dirY, cost + 1))
        
    
    return answer


print(solution([[1, 1, 7, 4], [3, 2, 5, 5], [4, 3, 6, 9], [2, 6, 8, 8]], 1, 3, 7, 8))   # 17
print(solution([[1, 1, 8, 4], [2, 2, 4, 9], [3, 6, 9, 8], [6, 3, 7, 7]], 9, 7, 6, 1))   # 11
print(solution([[1, 1, 5, 7]], 1, 1, 4, 7))   # 9
print(solution([[2, 1, 7, 5], [6, 4, 10, 10]], 3, 1, 7, 10))   # 15
print(solution([[2, 2, 5, 5], [1, 3, 6, 4], [3, 1, 4, 6]], 1, 4, 6, 3))   # 10

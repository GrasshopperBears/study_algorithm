def solution(m, n, board):
    answer = 0
    board = list(map(list, zip(*board)))
    dirs = [[0, 0], [0, 1], [1, 0], [1, 1]]
    m, n = n, m
    currentSet = set()
    
    def visit(r, c):
        nonlocal board, currentSet
        
        if r >= m-1 or c >= n-1 or (r, c) in currentSet: return
        current = board[r][c]
        if current == '0': return
        
        if current != board[r+1][c] or current != board[r][c+1] or current != board[r+1][c+1]:
            return
        visit(r+1, c)
        visit(r, c+1)
        visit(r+1, c+1)
        for dir in dirs:
            currentSet.add((r+dir[0], c+dir[1]))
    
    while True:
        for i in range(m):
            for j in range(n):
                visit(i, j)
        if len(currentSet) == 0:
            break
        answer += len(currentSet)
        for i, j in currentSet:
            board[i][j] = '0'
        for i in range(m):
            nextLine = list(filter(lambda x: x != '0', board[i]))
            board[i] = ['0'] * (n - len(nextLine)) + nextLine
        currentSet = set()
        
    return answer


print(solution(4, 5, ["CCBDE", "AAADE", "AAABF", "CCBBF"]))
print(solution(6, 5, ["CCZXZ", "CCZXZ", "XXZXZ", "AAZAA", "AAAAA", "ZAAXX"]))
print(solution(6, 6, ["AABBEE", "AAAEEE", "VAAEEV", "AABBEE", "AACCEE", "VVCCEE"]))

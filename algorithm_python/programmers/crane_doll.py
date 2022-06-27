def solution(board, moves):
    N = len(board)
    basket = []
    heights = [N for _ in range(N)]
    moves = list(map(lambda x: x - 1, moves))
    cnt = 0
    
    for j in range(N):
        for i in range(N):
            if board[i][j] > 0:
                heights[j] = i
                break
    
    for move in moves:
        if heights[move] == N: continue
        basket.append(board[heights[move]][move])
        heights[move] += 1
        while len(basket) > 1:
            if basket[-1] != basket[-2]: break
            basket = basket[:-2]
            cnt += 2
    
    return cnt

print(solution([[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]], [1,5,3,5,1,2,1,4]))   # 4

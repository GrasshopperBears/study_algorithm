def solution(n, s, a, b, fares):
    graph = [[float('inf') for _ in range(n+1)] for _ in range(n+1)]
    for i in range(1, n+1):
        graph[i][i] = 0
    for [x, y, cost] in fares:
        graph[x][y] = graph[y][x] = cost
    
    for mid in range(1, n+1):
        for i in range(1, n+1):
            for j in range(i+1, n+1):
                graph[i][j] = graph[j][i] = min(graph[i][j], graph[i][mid]+graph[mid][j])

    answer = float('inf')
    for i in range(1, n+1):
        answer = min(answer, graph[i][s]+graph[i][a]+graph[i][b])
    return answer

print(solution(6, 4, 6, 2, [[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]))
print(solution(7, 3, 4, 1, [[5, 7, 9], [4, 6, 4], [3, 6, 1], [3, 2, 3], [2, 1, 6]]))
print(solution(6, 4, 5, 6, [[2,6,6], [6,3,7], [4,6,7], [6,5,11], [2,5,12], [5,3,20], [2,4,8], [4,3,9]]))

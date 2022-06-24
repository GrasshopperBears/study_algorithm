from collections import deque
import math


def solution(n, vertex):
    graph = {}
    vertex.sort()
    
    for i in range(1, n+1):
        graph[i] = []
    for [a, b] in vertex:
        graph[a].append(b)
        graph[b].append(a)
    
    dist = [0 for _ in range(n+1)]
    q = deque()
    q.append(1)

    while q:
        nextVisit = q.popleft()
        for adj in graph[nextVisit]:
            if adj == 1: continue
            if dist[adj] == 0:
                q.append(adj)
                dist[adj] = dist[nextVisit]+1

    return dist.count(max(dist))


print(solution(6, [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]))    # 3

import sys


(vertex, edge) = map(int, sys.stdin.readline().split())
start = int(sys.stdin.readline())
INF = sys.maxsize
graph = {}
cost = [INF for i in range(vertex + 1)]
cost[start] = 0
visited = [False for i in range(vertex + 1)]
adj = [start]


def find_min_vertex(adj_ls):
    min_val = sys.maxsize
    min_node = 0
    for i in adj_ls:
        if min_val > cost[i] and (not visited[i]):
            min_val = cost[i]
            min_node = i
    if min_node == 0:
        return -1
    return min_node


for i in range(edge):
    (x, y, z) = map(int, sys.stdin.readline().split())
    updated = False
    if x in graph:
        for j in graph[x]:
            if j[0] == y:
                j[1] = min(z, j[1])
                updated = True
        if not updated:
            graph[x].append([y, z])
    else:
        graph[x] = [[y, z]]

while find_min_vertex(adj) != -1:
    visited[start] = True
    adj.remove(start)
    if start in graph:
        for i in graph[start]:
            if not visited[i[0]]:
                adj.append(i[0])
                cost[i[0]] = min(cost[start] + i[1], cost[i[0]])
    start = find_min_vertex(adj)

for i in range(1, vertex + 1):
    if cost[i] == INF:
        print('INF')
    else:
        print(cost[i])

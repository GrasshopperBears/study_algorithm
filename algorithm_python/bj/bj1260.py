import sys


def dfs(st):
    if visit[st]:
        return
    visit[st] = True
    print(st, end=' ')
    queue = []
    for i in range(1, nodeNum + 1):
        if (not visit[i]) and graph[st][i] == 1 and (i not in queue):
            queue.append(i)
    while queue:
        dfs(queue[0])
        del queue[0]


def bfs(st):
    queue = [st]
    while queue:
        curr = queue[0]
        visit[curr] = True
        print(curr, end=' ')
        del queue[0]
        for i in range(1, nodeNum + 1):
            if (not visit[i]) and graph[curr][i] == 1 and (i not in queue):
                queue.append(i)


nodeNum, edgeNum, start = map(int, sys.stdin.readline().split())
graph = [[0 for i in range(nodeNum + 1)] for j in range(nodeNum + 1)]
visit = [False for i in range(nodeNum + 1)]

for i in range(edgeNum):
    x, y = map(int, sys.stdin.readline().split())
    graph[x][y] = 1
    graph[y][x] = 1

dfs(start)
visit = [False for i in range(nodeNum + 1)]
print()
bfs(start)

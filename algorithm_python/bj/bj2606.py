import sys


computerNum = int(sys.stdin.readline())
edgeNum = int(sys.stdin.readline())
graph = [[0 for i in range(computerNum + 1)] for j in range(computerNum + 1)]
infected = [False for i in range(computerNum + 1)]
queue = [1]
infectedNumber = 0

for i in range(edgeNum):
    (x, y) = list(map(int, sys.stdin.readline().split()))
    graph[x][y] = 1
    graph[y][x] = 1

while queue:
    com = queue[0]
    infected[com] = True
    for i in range(1, computerNum + 1):
        if graph[com][i] == 1 and (i not in queue) and (not infected[i]):
            queue.append(i)
    del queue[0]

for i in range(1, computerNum + 1):
    if infected[i]:
        infectedNumber += 1

print(infectedNumber - 1)

import sys

stdin = sys.stdin
lineNum = int(stdin.readline())
t = []
costs = [[0 for _ in range(lineNum)] for _ in range(lineNum)]
for i in range(lineNum):
    t.append(list(map(int, stdin.readline().split(' '))))
costs[0][0] = t[0][0]
for i in range(1, lineNum):
    for j in range(i+1):
        if j == 0:
            costs[i][0] = costs[i-1][0] + t[i][j]
        elif j == lineNum - 1:
            costs[i][j] = costs[i-1][j-1] + t[i-1][j-1]
        else:
            costs[i][j] = max(costs[i-1][j-1], costs[i-1][j]) + t[i][j]
print(max(costs[-1]))

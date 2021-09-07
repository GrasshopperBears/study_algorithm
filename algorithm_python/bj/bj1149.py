import sys
stdin = sys.stdin
houseNum = int(stdin.readline())
costs = []
for i in range(houseNum):
    costs.append(list(map(int, stdin.readline().split(' '))))
ans = [[0, 0, 0] for j in range(houseNum)]
ans[0] = costs[0]
for i in range(1, houseNum):
    ans[i][0] = min(ans[i - 1][1], ans[i - 1][2]) + costs[i][0]
    ans[i][1] = min(ans[i - 1][0], ans[i - 1][2]) + costs[i][1]
    ans[i][2] = min(ans[i - 1][0], ans[i - 1][1]) + costs[i][2]

print(min(ans[-1]))

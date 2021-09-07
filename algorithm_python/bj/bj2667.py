import sys


ans = []
n = int(sys.stdin.readline())
visit = [[False for j in range(n)] for i in range(n)]
apt = []
for i in range(n):
    apt.append(list(map(int, list(sys.stdin.readline().strip()))))


def helper(i, j):
    global visit
    global apt
    visit[i][j] = True
    nums = 1
    if apt[i][j] == 0:
        return 0
    if i > 0 and apt[i-1][j] == 1 and not visit[i-1][j]:
        nums += helper(i-1, j)
    if j > 0 and apt[i][j-1] == 1 and not visit[i][j-1]:
        nums += helper(i, j-1)
    if i < n-1 and apt[i+1][j] == 1 and not visit[i+1][j]:
        nums += helper(i+1, j)
    if j < n-1 and apt[i][j+1] == 1 and not visit[i][j+1]:
        nums += helper(i, j+1)
    return nums


for i in range(n):
    for j in range(n):
        if apt[i][j] == 1 and not visit[i][j]:
            ans.append(helper(i, j))


ans.sort()
print(len(ans))
for i in ans:
    print(i)

import sys
sys.setrecursionlimit(10**6)

def helper(vs, arr, i, j, wd, ht):
    vs[i][j] = True
    nums = 1
    if arr[i][j] == 0:
        return False
    if i > 0 and arr[i-1][j] == 1 and not vs[i-1][j]:
        nums += helper(vs, arr, i-1, j, wd, ht)
    if j > 0 and arr[i][j-1] == 1 and not vs[i][j-1]:
        nums += helper(vs, arr, i, j-1, wd, ht)
    if i < ht-1 and arr[i+1][j] == 1 and not vs[i+1][j]:
        nums += helper(vs, arr, i+1, j, wd, ht)
    if j < wd-1 and arr[i][j+1] == 1 and not vs[i][j+1]:
        nums += helper(vs, arr, i, j+1, wd, ht)
    return True


tc = int(sys.stdin.readline())
for a in range(tc):
    ans = 0
    [w, h, n] = list(map(int, sys.stdin.readline().split(' ')))
    visit = [[False for j in range(w)] for i in range(h)]
    plt = [[0 for j in range(w)] for i in range(h)]
    for i in range(n):
        [x, y] = list(map(int, sys.stdin.readline().split(' ')))
        plt[y][x] = 1
    for i in range(h):
        for j in range(w):
            if plt[i][j] == 1 and not visit[i][j] and helper(visit, plt, i, j, w, h):
                ans += 1
    print(ans)

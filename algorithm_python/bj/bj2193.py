import sys

stdin = sys.stdin
n = int(stdin.readline())
dp = [[0, 1] for _ in range(n)]
for i in range(1, n):
    dp[i][0] = sum(dp[i-1])
    dp[i][1] = dp[i-1][0]
print(sum(dp[-1]))

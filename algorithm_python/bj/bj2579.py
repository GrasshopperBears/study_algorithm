import sys

stdin = sys.stdin
stairNum = int(stdin.readline())
scores = []
for i in range(stairNum):
    scores.append(int(stdin.readline()))

if stairNum == 1:
    print(scores[0])
    exit(0)
if stairNum == 2:
    print(scores[0] + scores[1])
    exit(0)

dp = [[0, 0] for j in range(stairNum)]
dp[0] = [scores[0], 0]
dp[1] = [scores[0] + scores[1], scores[1]]
for i in range(2, stairNum):
    dp[i][0] = dp[i-1][1] + scores[i]
    dp[i][1] = max(dp[i-2]) + scores[i]

print(max(dp[-1]))

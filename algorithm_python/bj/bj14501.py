import sys

stdin = sys.stdin
days = int(stdin.readline())
info = [[0, 0] for _ in range(days)]
for i in range(days):
    info[i] = list(map(int, stdin.readline().split(' ')))
profit = [0 for _ in range(days)]
for i in range(days - 1, -1, -1):
    if info[i][0] + i <= days:
        profit[i] = max(info[i][1] + (profit[i + info[i][0]] if info[i][0] + i < days else 0), profit[i+1] if i+1 < days else 0)
    else:
        profit[i] = profit[i+1] if i+1 < days else 0

print(profit[0])

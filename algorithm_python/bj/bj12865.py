import sys


(stuffNum, limit) = map(int, sys.stdin.readline().split())
weight = []
values = []
cache = [[-1 for i in range(limit + 1)] for j in range(stuffNum)]


def find_max_val(i, w):
    if cache[i][w] != -1:
        return cache[i][w]
    if i == 0:
        tmp = values[0] if w >= weight[0] else 0
        cache[i][w] = tmp
        return tmp
    if weight[i] > w:
        return find_max_val(i - 1, w)
    tmp = max(find_max_val(i - 1, w), find_max_val(i - 1, w - weight[i]) + values[i])
    cache[i][w] = tmp
    return tmp


for i in range(stuffNum):
    (x, y) = map(int, sys.stdin.readline().split())
    weight.append(x)
    values.append(y)

print(find_max_val(stuffNum - 1, limit))

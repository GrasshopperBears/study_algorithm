import sys

stdin = sys.stdin
(n, l) = int(stdin.readline())
trees = list(map(int, stdin.readline()))

prev = 0
nxt = max(trees)

while prev != nxt:
    mid = (prev + nxt) / 2
    if


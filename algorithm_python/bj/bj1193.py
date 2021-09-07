import sys

n = int(sys.stdin.readline())
i = 1
s = 0

while True:
    s += i
    if s >= n:
        break
    i += 1

d = (1 + (s - n)) if i % 2 == 0 else (n - (s - i))
print(f'{i + 1 - d}/{d}')

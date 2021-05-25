import sys


def find(lo, hi, n):
    if lo == hi:
        return lo
    elif hi == lo + 1:
        return lo if mem[lo] >= n else hi

    mid = (lo + hi) // 2
    if mem[mid] == n:
        return mid
    elif mem[mid] > n:
        return find(lo, mid, n)
    else:
        return find(mid + 1, hi, n)


size = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
mem = [None for i in range(size)]
longest_idx = 0
mem[0] = arr[0]

for i in arr:
    if mem[longest_idx] < i:
        longest_idx += 1
        mem[longest_idx] = i
    else:
        mem[find(0, longest_idx, i)] = i

print(longest_idx + 1)

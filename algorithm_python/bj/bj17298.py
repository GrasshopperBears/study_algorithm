import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split(' ')))
result = []
srt = []
idx = len(arr) - 1

while len(srt) < n:
    i = 0
    if len(srt) == 0:
        result.append(-1)
        srt.append(arr[idx])
    else:
        while i < len(srt) and arr[idx] > srt[i]:
            i += 1
        result.append(srt[i] if i < len(srt) else -1)
        srt.insert(i, arr[idx])
    idx -= 1
result.reverse()
print(f'{" ".join(map(str, result))}')

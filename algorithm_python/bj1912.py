import sys


length = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
largest = [0 for i in range(length)]
largest[0] = arr[0]

for i in range(1, length):
    largest[i] = max(arr[i], largest[i - 1] + arr[i])

print(max(largest))

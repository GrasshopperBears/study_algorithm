import sys

num = int(sys.stdin.readline())
endWith = [0, 1, 1, 1, 1, 1, 1, 1, 1, 1]
for i in range(num - 1):
    tmp = [endWith[1]]
    for j in range(1, 9):
        tmp.append((endWith[j - 1] + endWith[j + 1]) % 1000000000)
    tmp.append(endWith[8])
    endWith = tmp

print(sum(endWith) % 1000000000)

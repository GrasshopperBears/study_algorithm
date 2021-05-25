import sys


str1 = sys.stdin.readline().strip()
str2 = sys.stdin.readline().strip()
lcsArray = [[0 for _ in range(len(str1) + 1)] for _ in range(len(str2) + 1)]

for i in range(1, len(str2) + 1):
    for j in range(1, len(str1) + 1):
        if str2[i - 1] == str1[j - 1]:
            lcsArray[i][j] = lcsArray[i - 1][j - 1] + 1
        else:
            lcsArray[i][j] = max(lcsArray[i - 1][j], lcsArray[i][j - 1])

print(max(lcsArray[-1]))

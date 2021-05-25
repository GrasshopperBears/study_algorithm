import sys

caseNumber = int(sys.stdin.readline())


def calcReverse(size, arr):
    cost = 0
    posArr = [0 for x in range(size)]
    for j in range(len(arr)):
        posArr[arr[j] - 1] = j + 1
    for j in range(len(arr) - 1):
        cost += (posArr[j] - (j + 1) + 1)
        to = posArr[j]
        if j + 1 == to:
            continue
        for k in range(j, len(arr)):
            el = posArr[k]
            if j + 1 <= el <= to:
                posArr[k] = (to + j + 1 - el)
    return cost


def main(itr):
    n = int(sys.stdin.readline())
    ls = list(map(int, sys.stdin.readline().split(' ')))
    result = calcReverse(n, ls)
    print('Case #{}: {}'.format(itr + 1, result))


for i in range(caseNumber):
    main(i)

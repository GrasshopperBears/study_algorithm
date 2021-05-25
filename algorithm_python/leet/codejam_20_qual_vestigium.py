import sys

caseNumber = int(sys.stdin.readline())


def helper(ls):
    trace = 0
    rowRep = 0
    colRep = 0

    for k in range(len(ls)):
        trace += ls[k][k]
    for row in range(len(ls)):
        checkDic = {}
        for col in range(len(ls)):
            curr = ls[row][col]
            if curr in checkDic:
                rowRep += 1
                break
            else:
                checkDic[curr] = 1
    for col in range(len(ls)):
        checkDic = {}
        for row in range(len(ls)):
            curr = ls[row][col]
            if curr in checkDic:
                colRep += 1
                break
            else:
                checkDic[curr] = 1

    return trace, rowRep, colRep


def main(itr):
    n = int(sys.stdin.readline())
    ls = []
    for j in range(n):
        ls.append(list(map(int, sys.stdin.readline().split(' '))))
    k, r, c = helper(ls)
    print('Case #{}: {} {} {}'.format(itr+1, k, r, c))


for i in range(caseNumber):
    main(i)
import sys

caseNumber = int(sys.stdin.readline())


def calcReverse(t, c):
    if c < t - 1 or c > (t * (t + 1) / 2 - 1):
        return None
    costList = [1 for j in range(t - 1)]
    c -= (t - 1)
    idx = t - 2
    while c > 0:
        tmp = min(idx + 1, c)
        costList[idx] += tmp
        c -= tmp
        idx -= 1
    result = [x+1 for x in range(t)]
    for j in range(t-1):
        to = t - j - 2
        fr = costList[j] + to - 1
        if to == fr:
            continue
        while to <= fr:
            tmp = result[fr]
            result[fr] = result[to]
            result[to] = tmp
            to += 1
            fr -= 1

    return result


def main(itr):
    t, c = list(map(int, sys.stdin.readline().split(' ')))
    result = calcReverse(t, c)
    if result is not None:
        result = list(map(str, result))
    print('Case #{}: {}'.format(itr + 1, 'IMPOSSIBLE' if result is None else ' '.join(result)))


for i in range(caseNumber):
    main(i)
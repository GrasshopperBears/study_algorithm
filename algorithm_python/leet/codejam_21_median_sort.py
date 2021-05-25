import sys

t, n, q = list(map(int, sys.stdin.readline().split(' ')))


def medianSort():
    return 0


def main(itr):
    result = medianSort()
    if result is not None:
        result = list(map(str, result))
    print('Case #{}: {}'.format(itr + 1, 'IMPOSSIBLE' if result is None else ' '.join(result)))


for i in range(t):
    main(i)

import sys

caseNumber = int(sys.stdin.readline())


def movePtr(front, back, s):
    frontMoved, backMoved = True if front == 0 and s[back] == '?' else False, False
    while True:
        if back == len(s) - 1:
            break
        if not backMoved:
            back += 1
            backMoved = True
            continue
        elif s[back] == '?':
            back += 1
            continue
        break

    while True:
        if front == back - 1:
            break
        if not frontMoved or s[front] == '?':
            front += 1
            frontMoved = True
            continue
        elif front < len(s)-1 and s[front + 1] == '?':
            break
        elif s[front] == '?':
            front += 1
            continue
        break

    return front, back


def calc(x, y, s):
    if len(s) <= 1:
        return 0
    front, back = 0, 1
    cost = 0
    while True:
        if s[front] == 'C' and s[back] == 'J':
            cost += x
        elif s[front] == 'J' and s[back] == 'C':
            cost += y
        if back == len(s) - 1:
            break
        front, back = movePtr(front, back, s)

    return cost


def main(itr):
    x, y, s = sys.stdin.readline().split(' ')
    x = int(x)
    y = int(y)
    result = calc(x, y, s.strip())
    print('Case #{}: {}'.format(itr + 1, result))


for i in range(caseNumber):
    main(i)

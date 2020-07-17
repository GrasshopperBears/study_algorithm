import sys


def find_between(start, end, ls):
    for j in range(start, end):
        if j in ls:
            return True
    return False


brackets = ['(', ')', '[', ']']

while True:
    line = sys.stdin.readline().rstrip()
    if line == '.':
        break

    sbStack = []
    lbStack = []
    broke = False
    for i in range(len(line)):
        ch = line[i]
        if ch not in brackets:
            continue
        if ch == '(':
            sbStack.append(i)
        elif ch == '[':
            lbStack.append(i)
        elif ch == ')':
            if len(sbStack) == 0 or find_between(sbStack.pop(), i, lbStack):
                print('no')
                broke = True
                break
        elif ch == ']':
            if len(lbStack) == 0 or find_between(lbStack.pop(), i, sbStack):
                print('no')
                broke = True
                break
    if broke:
        continue
    elif len(sbStack) == 0 and len(lbStack) == 0:
        print('yes')
    else:
        print('no')
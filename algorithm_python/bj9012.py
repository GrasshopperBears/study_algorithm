import sys


caseNum = int(sys.stdin.readline())
for i in range(caseNum):
    line = sys.stdin.readline().strip()
    stack = []
    broke = False
    for j in line:
        if len(stack) == 0 and j == ')':
            broke = True
            break
        elif j == '(':
            stack.append(j)
        else:
            stack.pop()
    if broke or len(stack) != 0:
        print("NO")
    else:
        print("YES")

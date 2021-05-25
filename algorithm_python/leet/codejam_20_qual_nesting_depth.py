import sys

caseNumber = int(sys.stdin.readline())


def processInsert(line):
    currDepth = 0
    pos = 0
    while pos < len(line):
        currNum = int(line[pos])
        if currDepth == currNum:
            pos += 1
            continue
        elif currDepth < currNum:
            for j in range(currNum - currDepth):
                line = line[:pos] + '(' + line[pos:]
            pos += (currNum - currDepth)
            currDepth = currNum
        else:
            for j in range(currDepth - currNum):
                line = line[:pos] + ')' + line[pos:]
            pos += (currDepth - currNum)
            currDepth = currNum
    line += (')' * currDepth)
    return line


def processModify(line):
    if len(line) <= 1:
        return line
    prevPos = 0
    nextPos = 1
    while nextPos < len(line):
        if line[prevPos] == ')' and line[nextPos] == '(':
            line = line[:prevPos - 1] + line[nextPos + 1:]
            prevPos -= 1
            nextPos += 1
        else:
            prevPos += 1
            nextPos += 1
    return line


def main(itr):
    line = sys.stdin.readline().strip()
    line = processInsert(line)
    line = processModify(line)
    print('Case #{}: {}'.format(itr+1, line))


for i in range(caseNumber):
    main(i)

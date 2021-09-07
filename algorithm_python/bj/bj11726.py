import sys

caseNum = int(sys.stdin.readline())
numbers = [1, 1]

if caseNum == 1:
    print(numbers[1])
else:
    for i in range(2, caseNum + 1):
        numbers.append(numbers[i - 2] + numbers[i - 1])
    print(numbers[caseNum] % 10007)

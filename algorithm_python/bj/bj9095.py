import sys

caseNum = int(sys.stdin.readline())
numbers = []

for i in range(caseNum):
    numbers.append(int(sys.stdin.readline()))

maxNum = max(numbers);
possibleCases = [1 for i in range(maxNum + 1)]

for i in range(1, maxNum + 1):
    possibleCases[i] = (possibleCases[i - 1] if i-1 >= 0 else 0) + (possibleCases[i - 2] if i-2 >= 0 else 0) + (possibleCases[i - 3] if i-3 >= 0 else 0)

for i in range(caseNum):
    print(possibleCases[numbers[i]])

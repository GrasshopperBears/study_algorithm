import sys


n = int(sys.stdin.readline())
seq = []
stack = []
numbers = [i for i in range(1, n + 1)]
idx = -1
for i in range(n):
    seq.append(int(sys.stdin.readline()))

while len(numbers) != 0:
    curr = seq[0]
    if idx == -1:
        stack.append('+')
        idx += 1
    elif curr < numbers[idx]:
        break
    elif curr == numbers[idx]:
        stack.append('-')
        del numbers[idx]
        del seq[0]
        idx -= 1
    elif curr > numbers[idx]:
        stack.append('+')
        idx += 1

if len(numbers) != 0:
    print('NO')
else:
    print('\n'.join(stack))

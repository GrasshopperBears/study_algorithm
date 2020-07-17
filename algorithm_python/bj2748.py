import sys


num = int(sys.stdin.readline())
fib = [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597]

if num <= 17:
    print(fib[num])
else:
    for i in range(18, num + 1):
        fib.append(fib[i - 2] + fib[i - 1])
    print(fib[num])

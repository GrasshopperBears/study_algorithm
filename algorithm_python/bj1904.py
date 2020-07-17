import sys


num = int(sys.stdin.readline())
if num <= 2:
    print(num)
else:
    n1 = 1
    n2 = 2
    for i in range(num - 2):
        tmp = (n1 + n2) % 15746
        n1 = n2
        n2 = tmp
    print(n2)

import sys


n = int(sys.stdin.readline())
count_dict = {}

for i in range(n):
    num = int(sys.stdin.readline())
    if num in count_dict:
        count_dict[num] += 1
    else:
        count_dict[num] = 1

for i in range(1, 10001):
    if i in count_dict:
        for j in range(count_dict[i]):
            print(i)

"""
import sys
n=int(sys.stdin.readline())
l=[0]*10001
for i in range (n):
    l[int(sys.stdin.readline())]+=1
for i in range (10001):
    sys.stdout.write(('%s\n' %i)*l[i])
"""
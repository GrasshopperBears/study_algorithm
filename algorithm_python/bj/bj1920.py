import sys

stdin = sys.stdin
int(stdin.readline())
origin = {}
for i in map(int, stdin.readline().split()):
    if i not in origin:
        origin[i] = True

int(stdin.readline())
for i in map(int, stdin.readline().split()):
    if i in origin:
        print(1)
    else:
        print(0)

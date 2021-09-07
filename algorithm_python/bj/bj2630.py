import sys


def helper(arr):
    white = blue = 0

    if len(arr) == 1:
        return 0 if arr[0][0] == 1 else 1, 1 if arr[0][0] == 1 else 0


    return white, blue


def main():
    n = int(sys.stdin.readline().split(' ')[1])
    paper = []
    for i in range(n):
        paper.append(list(map(int, sys.stdin.readline().split(' '))))
    white, blue = helper(paper)
    print(white)
    print(blue)


main()

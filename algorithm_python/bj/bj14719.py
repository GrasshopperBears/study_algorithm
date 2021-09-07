import sys


def main():
    width = int(sys.stdin.readline().split(' ')[1])
    blocks = list(map(int, sys.stdin.readline().split(' ')))
    ans = 0
    if len(blocks) == 0:
        print(0)
        return
    currMax = max(blocks)
    while currMax > 0:
        on = False
        currentHeightWater = 0
        tmpHeight = 0
        for i in range(width):
            if blocks[i] >= currMax:
                if on:
                    currentHeightWater += tmpHeight
                    tmpHeight = 0
                on = True
            elif on:
                tmpHeight += 1
        ans += currentHeightWater
        currMax -= 1

    print(ans)


main()

def solution(n):
    triangle = [[0 for _ in range(n)] for _ in range(n)]
    i, j = 0, 0
    direction = 0
    current = 1
    maxVal = int(n * (n+1) / 2)
    currWidth = n-1
    currBase = 0
    
    while current <= maxVal:
        triangle[i][j] = current
        relativeCurrPos = current - currBase
        
        if direction == 0:
            if relativeCurrPos == currWidth+1:
                direction = 1
                j += 1
            else:
                i += 1
        elif direction == 1:
            if relativeCurrPos == 2*currWidth+1:
                i -= 1
                j -= 1
                direction = 2
            else:
                j += 1
        else :
            if relativeCurrPos == 3*currWidth:
                currBase += 3 * currWidth
                currWidth -= 3
                i += 1
                direction = 0
            else:
                j -= 1
                i -= 1
        current += 1
        
    answer = []
    for i, row in enumerate(triangle):
        answer.extend(row[:i+1])
    return answer
    

print(solution(1))
print(solution(2))
print(solution(3))
print(solution(4))
print(solution(5))
print(solution(6))

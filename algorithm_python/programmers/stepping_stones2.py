def solution(distance, rocks, n):
    left, right = 0, distance
    rocks.sort()
    rocks = [0] + rocks + [distance]
    
    while left <= right:
        mid = (left + right) // 2
        removeCnt = n
        currentIdx, nextIdx = 0, 1
        isLong = False
        while nextIdx < len(rocks):
            if rocks[nextIdx] - rocks[currentIdx] < mid:
                if removeCnt <= 0:
                    isLong = True
                    right = mid - 1
                    break
                removeCnt -= 1
                nextIdx += 1
            else:
                currentIdx = nextIdx
                nextIdx += 1
        if removeCnt >= 0 and not isLong:
            left = mid + 1
            
    return right


print(solution(25, [2, 14, 11, 21, 17], 2))     # 4
print(solution(23, [3, 6, 9, 10, 14, 17], 2))   # 3

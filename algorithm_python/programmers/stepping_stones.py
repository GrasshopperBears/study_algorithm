def solution(stones, k):
    left, right = 0, 200000000
    
    while left <= right:
        mid = (left+right) // 2
        satisfy = True
        currentK = 0
        for stone in stones:
            if stone > mid: currentK = 0
            else: currentK += 1
            
            if currentK >= k:
                satisfy = False
                break
        if satisfy: left = mid+1
        else: right = mid-1
                 
    return left


print(solution([2, 4, 5, 3, 2, 1, 4, 2, 5, 1], 3))

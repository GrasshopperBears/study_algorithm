def solution(n, k):
    prev = 1
    answer = []
    used = [i for i in range(n)]
    
    for i in range(2, n): prev *= i
    
    while len(answer) < n:
        prevCnt = (k-1) // prev
        nxt = used[prevCnt]
        answer.append(nxt+1)
        used.pop(prevCnt)
        k -= prevCnt * prev
        if prev > 1:
            prev = int(prev/(n-len(answer)))

    return answer

print(solution(3, 5))

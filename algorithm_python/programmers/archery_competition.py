def solution(n, info):
    maxScore = 0
    answer = None
    
    def shot(balance, remain, scores):
        nonlocal info, answer, maxScore
        currTarget = 10 - len(scores)
        if currTarget == 0:
            scores.append(remain)
            if balance > 0:
                if balance > maxScore:
                    maxScore = balance
                    answer = scores
                elif balance == maxScore:
                    cmp = False
                    for i in range(10, -1, -1):
                        if scores[i] > answer[i]:
                            cmp = True
                            break
                        elif scores[i] < answer[i]:
                            break
                    if cmp:
                        answer = scores
            return
        apeach = info[10-currTarget]
        if remain > apeach:
            shot(balance+currTarget, remain - (apeach+1), scores+[apeach+1])
        shot(balance-(currTarget if apeach > 0 else 0), remain, scores + [0])
    
    shot(0, n, [])
    return answer if maxScore > 0 else [-1]
    
    
print(solution(5, [2,1,1,1,0,0,0,0,0,0,0])) # [0,2,2,0,1,0,0,0,0,0,0]
print(solution(1, [1,0,0,0,0,0,0,0,0,0,0])) # [-1]
print(solution(9, [0,0,1,2,0,1,1,1,1,1,1])) # [1,1,2,0,1,2,2,0,0,0,0]
print(solution(10, [0,0,0,0,0,0,0,0,3,4,3]	)) # [1,1,1,1,1,1,1,1,0,0,2]

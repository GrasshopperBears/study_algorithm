from collections import deque
import math

def solution(name):
    q = deque()
    for i in range(len(name)):
        if name[i] != 'A':
            q.append(i)
    
    result = math.inf
    
    def change(idx, isRight, cost, sameDir):
        nonlocal q, result
        
        if len(q) == 0:
            if cost < result: result = cost
            return
        if isRight:
            current = q.popleft()
        else:
            current = q.pop()
        currentCode = ord(name[current])
        
        if sameDir:
            currentCost = abs(current - idx)
        else:
            currentCost = len(name) - abs(current - idx)
        currentCost += min(currentCode - 65, 91 - currentCode)
        print(idx, currentCost)
        
        change(current, True, cost + currentCost, isRight)
        if len(q) > 0: change(current, False, cost + currentCost, not isRight)
        
        if isRight: q.appendleft(current)
        else: q.append(current)
        
        
    change(0, True, 0, True)
    change(0, False, 0, False)
    return result

print(solution("JAN"))

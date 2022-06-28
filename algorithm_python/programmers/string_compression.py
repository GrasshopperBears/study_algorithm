import math

def solution(s):
    minLen = len(s)
    currLen = 2
    
    for currLen in range(1, math.ceil(len(s)/2)+1):
        currComp = 0
        last = s[:currLen]
        idx = currLen
        cts = 1
        
        while idx <= len(s):
            current = s[idx:idx+currLen]
            if last == current:
                cts += 1
            else:
                currComp += len(last)
                if cts > 1: currComp += len(str(cts))
                last = current
                cts = 1
            idx += currLen
        if len(last) < currLen:
            currComp += len(last)
        minLen = min(minLen, currComp)
    
    return minLen

print(solution("aabbaccc")) # 7
print(solution("ababcdcdababcdcd")) # 9
print(solution("abcabcdede")) # 8
print(solution("abcabcabcabcdededededede")) # 14
print(solution("xababcdcdababcdcd")) # 17

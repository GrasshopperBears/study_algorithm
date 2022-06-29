from itertools import combinations


def countLarger(arr, n):
    left, right = 0, len(arr) - 1
    
    while left < right:
        mid = int((left + right)/2)
        if arr[mid] >= n:
            right = mid
        else:
            left = mid+1
    
    return len(arr) - left if arr[left] >= n else 0


def solution(info, query):
    answer = []
    dic = {}
    possibleCombinations = []
    
    for i in range(5):
        possibleCombinations += combinations(range(4), i)
    
    for apply in info:
        [lang, pos, exp, soul, score] = apply.split()
        score = int(score)
        candidate = [lang, pos, exp, soul]
        for use in possibleCombinations:
            keys = []
            for i in range(len(candidate)):
                if i in use: keys.append(candidate[i])
                else: keys.append('-')
            keys = ''.join(keys)
            if keys not in dic:
                dic[keys] = [score]
            else:
                dic[keys].append(score)
    
    for key in dic: dic[key].sort()
    
    for q in query:
        [lang, _, pos, _, ex, _, soul, score] = q.split()
        currentKey = ''.join([lang, pos, ex, soul])
        if currentKey not in dic:
            answer.append(0)
            continue
        answer.append(countLarger(dic[currentKey], int(score)))
    
    return answer


print(solution(["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"], ["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]))

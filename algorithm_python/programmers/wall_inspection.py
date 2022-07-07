from itertools import permutations

def solution(n, weak, dist):
    minFriend = -1
    weakCnt, friendsNum = len(weak), len(dist)
    
    for i in range(weakCnt):
        weak.append(weak[i] + n)    
        
    for order in permutations(dist, friendsNum):
        for weakStartIdx in range(weakCnt):
            curr = weakStartIdx
            orderIdx = 0
            while orderIdx < friendsNum and curr - weakStartIdx < weakCnt:
                nxt = weak[curr] + order[orderIdx]
                orderIdx += 1
                while curr < 2*weakCnt and weak[curr] <= nxt:
                    curr += 1
            if curr - weakStartIdx == weakCnt and (minFriend < 0 or minFriend > orderIdx):
                minFriend = orderIdx
            

    return minFriend

print(solution(12, [1, 5, 6, 10], [1, 2, 3, 4]))    # 2
print(solution(12, [1, 3, 4, 9, 10], [3, 5, 7]))    # 1
print(solution(10, [0, 5], [2]))    # -1

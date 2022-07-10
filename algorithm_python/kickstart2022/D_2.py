def getCtsSum(arr, arrLen):
    pre = [0 for _ in range(arrLen+1)]
    post = [0 for _ in range(arrLen+1)]

    for i in range(1, arrLen+1):
        pre[i] = pre[i-1] + arr[i-1]
        post[i] = post[i-1] + arr[arrLen-i]
    
    return pre, post


def findMax(pre, post, k):
    dp = [0 for _ in range(min(k+1, len(pre)))]
    for cnt in range(1, len(dp)):
        for i in range(cnt+1):
            dp[cnt] = max(dp[cnt], pre[i] + post[cnt-i])

    return dp


def main(aLen, a, bLen, b, k):
    aPre, aPost = getCtsSum(a, aLen)
    bPre, bPost = getCtsSum(b, bLen)
    
    aDp = findMax(aPre, aPost, k)
    bDp = findMax(bPre, bPost, k)
    
    if aLen > bLen:
        aLen, bLen = bLen, aLen
        aDp, bDp = bDp, aDp
    
    answer = 0
    minCnt = 0 if bLen >= k else k - bLen
    maxCnt = aLen if aLen < k else k
    for i in range(minCnt, maxCnt+1):
        answer = max(aDp[i] + bDp[k-i], answer)
    
    return answer

testCases = int(input())
for i in range(testCases):
    aLen = int(input())
    a = list(map(int, input().split(' ')))
    bLen = int(input())
    b = list(map(int, input().split(' ')))
    k = int(input())
    print('Case #{}: {}'.format(i+1, main(aLen, a, bLen, b, k)))

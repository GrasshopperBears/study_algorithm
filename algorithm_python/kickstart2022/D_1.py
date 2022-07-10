def main(n, m, arr):
    answer = 0
    bound = n-m
    arr.sort()
    
    for i in range(n-1, bound, -1):
        answer += arr[i]
    
    mid = (bound+1) // 2
    if (bound+1) % 2 == 1:
        answer += arr[mid]
    else:
        answer += (arr[mid-1] + arr[mid]) / 2.0
    return answer

testCases = int(input())
for i in range(testCases):
    n, m = map(int, input().split(' '))
    arr = list(map(int, input().split(' ')))
    print('Case #{}: {}'.format(i+1, main(n, m, arr)))

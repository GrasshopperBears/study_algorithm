from collections import deque
import heapq

def main(a, b, k):
    answer = 0
    heap = []
    taskA = deque(a)
    taskB = deque(b)
    heapq.heappush(heap, (-taskA[0], True, 0))
    if len(taskA) > 1:
        heapq.heappush(heap, (-taskA[-1], True, -1))
    heapq.heappush(heap, (-taskB[0], False, 0))
    if len(taskB) > 1:
        heapq.heappush(heap, (-taskB[-1], False, -1))
    
    for _ in range(k):
        point, isTaskA, idx = heapq.heappop(heap)
        print(point, isTaskA, idx)
        answer -= point
        targetTask = taskA if isTaskA else taskB
        if idx == 0:
            targetTask.popleft()
        else:
            targetTask.pop()
        if len(targetTask) > 1:
            heapq.heappush(heap, (-targetTask[idx], isTaskA, idx))
        
    return answer

testCases = int(input())
for i in range(testCases):
    aLen = int(input())
    a = list(map(int, input().split(' ')))
    bLen = int(input())
    b = list(map(int, input().split(' ')))
    k = int(input())
    print('Case #{}: {}'.format(i+1, main(a, b, k)))

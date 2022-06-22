import heapq

def connectSticks(sticks):
    """
    :type sticks: List[int]
    :rtype: int
    """
    if len(sticks) == 1:
        return 0
    
    heapq.heapify(sticks)
    cost = 0
    
    while len(sticks) > 1:
        first = heapq.heappop(sticks)
        second = heapq.heappop(sticks)
        heapq.heappush(sticks, first+second)
        cost += (first+second)

    return cost

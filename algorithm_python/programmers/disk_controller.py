import heapq
import math

def solution(jobs):
    job_count = len(jobs)
    heap = []
    sorted_jobs = sorted(jobs, key=lambda x: x[0], reverse=True)
    time = 0
    total = 0
    
    while len(sorted_jobs) > 0 or len(heap) > 0:
        while len(sorted_jobs) > 0 and sorted_jobs[-1][0] <= time:
            last = sorted_jobs.pop()
            heapq.heappush(heap, (last[1], last[0]))
        if len(heap) > 0:
            selected_job = heapq.heappop(heap)
            total += (time + selected_job[0] - selected_job[1])
            time += selected_job[0]
        elif len(sorted_jobs):
            time = sorted_jobs[-1][0]
    
    return math.floor(total / job_count)

print(solution([[0, 3], [1, 9], [2, 6]]))   # 9

import math
from collections import defaultdict


def solution(fees, records):
    defaultEnd = 23 * 60 + 59
    [defaultTime, defaultFee, unitTime, unitFee] = fees
    timeIn = {}
    total = defaultdict(int)
    feeList = []
    
    def calcFee(duration):
        nonlocal defaultFee, unitFee, defaultTime, unitTime
        if duration <= defaultTime: return defaultFee
        return defaultFee + unitFee * math.ceil((duration - defaultTime) / unitTime)
    
    for record in records:
        [time, plateNum, recordType] = record.split(' ')
        [hh, mm] = list(map(int, time.split(':')))
        time = 60 * hh + mm
        plateNum = int(plateNum)
        if recordType == 'IN':
            timeIn[plateNum] = time
        else:
            total[plateNum] = total[plateNum] + time - timeIn[plateNum]
            del timeIn[plateNum]
    
    for plateNum, timeIn in timeIn.items():
        total[plateNum] = total[plateNum] + defaultEnd - timeIn
    
    for plateNum, totalTime in total.items():
        feeList.append((plateNum, calcFee(totalTime)))
    feeList.sort(key=lambda x: x[0])
    
    return list(map(lambda x: x[1], feeList))
        

# [14600, 34400, 5000]
print(solution([180, 5000, 10, 600], ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]))

# [0, 591]
print(solution([120, 0, 60, 591], ["16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"]))

# [14841]
print(solution([1, 461, 1, 10], ["00:00 1234 IN"]))

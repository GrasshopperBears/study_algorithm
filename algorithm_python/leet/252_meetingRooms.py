class Solution(object):
    def canAttendMeetings(self, intervals):
        if len(intervals) <= 1:
            return True
        intervals.sort(key=lambda interval: interval[0])
        for i in range(1, len(intervals)-1):
            if intervals[i][0] < intervals[i-1][1] or intervals[i][1] > intervals[i+1][0]:
                return False
        if intervals[-1][0] < intervals[-2][1]:
            return False
        return True

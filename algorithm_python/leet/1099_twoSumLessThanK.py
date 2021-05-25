class Solution(object):
    def twoSumLessThanK(self, nums, k):
        maxVal = -1
        for i in range(len(nums)-1):
            for j in range(i+1, len(nums)):
                if nums[i]+nums[j] < k:
                    maxVal = max(maxVal, nums[i]+nums[j])
        return maxVal

class Solution(object):
    def isMajorityElement(self, nums, target):
        length = len(nums)
        cnt = 0
        flag = False
        if nums[int(length/2)] != target:
            if length%2 == 1:
                return False
            elif nums[int(length/2)-1] != target:
                return False
        for num in nums:
            if num == target:
                cnt += 1
                if flag == False:
                    flag = True
            elif flag == True:
                break
        if cnt > length/2:
            return True
        return False

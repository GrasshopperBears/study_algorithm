class Solution(object):
    def countElements(self, arr):
        cnt = 0
        dic = {}
        for element in arr:
            dic[element] = dic[element]+1 if element in dic else 1
        for key in dic:
            if key+1 in dic:
                cnt += dic[key]
        return cnt
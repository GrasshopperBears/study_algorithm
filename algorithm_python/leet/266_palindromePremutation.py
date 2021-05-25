class Solution(object):
    def canPermutePalindrome(self, s):
        isThereOdd = False
        dic = {}
        for char in s:
            dic[char] = dic[char]+1 if char in dic else 1
        for key in dic:
            if dic[key]%2 == 1:
                if isThereOdd:
                    return False
                isThereOdd = True
        return True

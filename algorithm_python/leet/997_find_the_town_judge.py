class Solution(object):
  def findJudge(n, trust):
    believe_score = [0 for _ in range(n+1)]
    
    for [person, believe] in trust:
      believe_score[person] += 1
      believe_score[believe] -= 1
      
    for i in range(1, n+1):
      if believe_score[i] == -(n-1):
        return i
    return -1


print(Solution.findJudge(2, [[1,2]])) # 2
print(Solution.findJudge(3, [[1,3],[2,3]])) # 3
print(Solution.findJudge(3, [[1,3],[2,3],[3,1]])) # -1

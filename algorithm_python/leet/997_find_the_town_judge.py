class Solution(object):
  def findJudge(n, trust):
    believe_map = [[False for i in range(n+1)] for _ in range(n+1)]
    
    for [person, believe] in trust:
      believe_map[person][believe] = True
    
    candidates = []
    
    for i in range(1, n+1):
      believed = True
      for j in range(1, n+1):
        if j != i and not believe_map[j][i]:
          believed = False
          break
      if believed:
        candidates.append(i)
    
    for candidate in candidates:
      believe = False
      for i in range(1, n+1):
        if i != candidate and believe_map[candidate][i]:
          believe = True
          break
      if not believe:
        return candidate

    return -1


print(Solution.findJudge(2, [[1,2]])) # 2
print(Solution.findJudge(3, [[1,3],[2,3]])) # 3
print(Solution.findJudge(3, [[1,3],[2,3],[3,1]])) # -1

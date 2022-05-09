def singleNumber(nums):
  exist_set = set()
  
  for num in nums:
    try:
      exist_set.remove(num)
    except:
      exist_set.add(num)
  
  return exist_set.pop()

print(singleNumber([2,2,1])) # 1
print(singleNumber([4,1,2,1,2])) # 4
print(singleNumber([1])) # 1

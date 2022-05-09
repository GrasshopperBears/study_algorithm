def helper(nums, current):
  if len(nums) == 0:
    return [current]
  
  excluded = helper(nums[1:], current)
  included = helper(nums[1:], current + [nums[0]])
  return excluded + included


def subsets(nums):
  return helper(nums, [])

print(subsets([1,2,3]))
print(subsets([0]))

package leet80

func removeDuplicates(nums []int) int {
  result := 1
  prev := nums[0]
  prevCount := 1
  tail := 1
  
  for i := 1; i < len(nums); i++ {
    current := nums[i]
    if tail != i {
      nums[tail] = nums[i]
    }
    if prev == current {
      if prevCount == 2 {
        continue
      } else {
        result++
        prevCount++
        tail++
      }
    } else {
      result++
      prev = current
      prevCount = 1
      tail++
    }
  }
  return result
}

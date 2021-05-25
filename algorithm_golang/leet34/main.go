package main

import "fmt"

func searchRange(nums []int, target int) []int {
	left := 0
	right := len(nums)
	var mid int

	if len(nums) == 0 {
		return []int{-1, -1}
	}
	for left < right {
		mid = int(left + right) / int(2)
		if nums[mid] == target {
			break
		}
		if nums[mid] < target {
			left = mid + 1
		} else {
			right = mid
		}
	}
	if nums[mid] != target {
		return []int{-1, -1}
	}
	left = mid
	right = mid
	lflag := false
	rflag := false
	for nums[mid] == target {
		if lflag && rflag {
			break
		}
		if left - 1 >= 0 && nums[left-1] == target {
			left--
		} else {
			lflag = true
		}
		if right+1 <= len(nums)-1 && nums[right+1] == target {
			right++
		} else {
			rflag = true
		}
	}

	return []int{left, right}
}

func main() {
	arr := []int{0,0,1,2,2}
	result := searchRange(arr, 2)
	fmt.Println(result)
}

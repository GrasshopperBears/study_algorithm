package leet560_test

import (
	// "fmt"
	"testing"

	"github.com/stretchr/testify/assert"
)

func subarraySum(nums []int, k int) int {
	sumMap := make(map[int]int)
	sumMap[0] = 1
	sum := 0
	cnt := 0

	for idx := 0; idx < len(nums); idx++ {
		sum += nums[idx]
		prev, exist := sumMap[sum - k]
		if exist {
			cnt += prev
		}
		prev, exist = sumMap[sum]
		if exist {
			sumMap[sum] = prev + 1
		} else {
			sumMap[sum] = 1
		}
	}
	return cnt
}

func TestSubarraySum1(t *testing.T) {
	result := subarraySum([]int{1,1,1}, 2)
	answer := 2
	assert.Equal(t, answer, result)
}

func TestSubarraySum2(t *testing.T) {
	result := subarraySum([]int{1,2,3}, 3)
	answer := 2
	assert.Equal(t, answer, result)
}

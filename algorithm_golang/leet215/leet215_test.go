package leet215_test

import (
	// "fmt"
	"testing"

	"github.com/stretchr/testify/assert"
)

func partition(nums *[]int, lo int, hi int) int {
	if lo == hi { return hi }

	pivot := (*nums)[lo]
	left := lo + 1
	right := hi

	for {
		for ; (*nums)[left] < pivot && left < hi; { left++ }
		for ; (*nums)[right] > pivot && right > lo; { right-- }

		if left >= right { break }
		(*nums)[left], (*nums)[right] = (*nums)[right], (*nums)[left]
		left++
		right--
	}

	(*nums)[lo], (*nums)[right] = (*nums)[right], (*nums)[lo]

	return right
}

func findKthLargest(nums []int, k int) int {
	numsLen := len(nums)
	targetIdx := numsLen - k

	for left, right := 0, numsLen - 1; ; {
		offset := partition(&nums, left, right)
		if offset == targetIdx { break }
		if offset > targetIdx {
			right = offset - 1
		} else {
			left = offset + 1
		}
	}

	return nums[targetIdx]
}

func TestFindKthLargest1(t *testing.T) {
	result := findKthLargest([]int{3,2,1,5,6,4}, 2)
	answer := 5
	assert.Equal(t, answer, result)
}

func TestFindKthLargest2(t *testing.T) {
	result := findKthLargest([]int{3,2,3,1,2,4,5,5,6}, 4)
	answer := 4
	assert.Equal(t, answer, result)
}

func TestFindKthLargest3(t *testing.T) {
	result := findKthLargest([]int{1}, 1)
	answer := 1
	assert.Equal(t, answer, result)
}

func TestFindKthLargest4(t *testing.T) {
	result := findKthLargest([]int{2,1}, 1)
	answer := 2
	assert.Equal(t, answer, result)
}

func TestFindKthLargest5(t *testing.T) {
	result := findKthLargest([]int{7,6,5,4,3,2,1}, 2)
	answer := 6
	assert.Equal(t, answer, result)
}

func TestFindKthLargest6(t *testing.T) {
	result := findKthLargest([]int{3,3,3,3,3,3,3}, 1)
	answer := 3
	assert.Equal(t, answer, result)
}

package leet432_test

import (
	"strconv"
	"testing"

	"github.com/stretchr/testify/assert"
)

func findMaxInt(nums *[]int) int {
	max := (*nums)[0]

	for _, num := range *nums {
		if num > max { max = num }
	}
	return max
}

func findMaximumXOR(nums []int) int {
	maxXOR := 0
	digits := len(strconv.FormatInt(int64(findMaxInt(&nums)), 2))

	for i := digits - 1; i >= 0; i-- {
		maxXOR <<= 1
		currXOR := maxXOR ^ 1
		prefixSet := map[int]bool{}

		for _, num := range nums {
			prefixSet[num >> i] = true
		}

		for prefix := range prefixSet {
			if _, exist := prefixSet[prefix ^ currXOR]; exist {
				maxXOR |= 1
				break
			}
		}
	}

	return maxXOR
}

func TestFindMaximumXOR1(t *testing.T) {
	result := findMaximumXOR([]int{3,10,5,25,2,8})
	answer := 28
	assert.Equal(t, answer, result)
}

func TestFindMaximumXOR2(t *testing.T) {
	result := findMaximumXOR([]int{14,70,53,83,49,91,36,80,92,51,66,70})
	answer := 127
	assert.Equal(t, answer, result)
}

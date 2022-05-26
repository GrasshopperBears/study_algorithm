package leet62_test

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func combination(n int, r int) int {
	result := 1
	for i := 1; i <= r; i++ {
		result *= n
		n--
		result /= i
	}
	return result
}

func uniquePaths(m int, n int) int {
	selection := n - 1
	if m < n { selection = m - 1 }
	return combination(m + n - 2, selection)
}

func TestUniquePaths1(t *testing.T) {
	result := uniquePaths(3, 7)
	answer := 28
	assert.Equal(t, answer, result)
}

func TestUniquePaths2(t *testing.T) {
	result := uniquePaths(3, 2)
	answer := 3
	assert.Equal(t, answer, result)
}

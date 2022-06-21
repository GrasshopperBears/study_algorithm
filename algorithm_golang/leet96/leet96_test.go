package leet96_test

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func count(n int, resultMap *map[int]int) int {
	if val, ok := (*resultMap)[n]; ok { return val }

	mid := n / 2
	(*resultMap)[n] = 0

	for i := 0; i < mid; i++ {
		(*resultMap)[n] += (count(i, resultMap) * count(n - i - 1, resultMap))
	}
	(*resultMap)[n] *= 2

	if mid * 2 != n {
		child := count(n - mid - 1, resultMap)
		(*resultMap)[n] += child * child
	}
	return (*resultMap)[n]
}

func numTrees(n int) int {
	resultMap := map[int]int{}
	resultMap[0] = 1
	resultMap[1] = 1
	
	return count(n, &resultMap)
}

func TestNumTrees1(t *testing.T) {
	result := numTrees(3)
	answer := 5
	assert.Equal(t, answer, result)
}

func TestNumTrees2(t *testing.T) {
	result := numTrees(1)
	answer := 1
	assert.Equal(t, answer, result)
}

func TestNumTrees3(t *testing.T) {
	result := numTrees(4)
	answer := 14
	assert.Equal(t, answer, result)
}

func TestNumTrees4(t *testing.T) {
	result := numTrees(5)
	answer := 42
	assert.Equal(t, answer, result)
}

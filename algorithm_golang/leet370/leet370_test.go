package leet370_test

import (
	// "fmt"
	"testing"

	"github.com/stretchr/testify/assert"
)

func getModifiedArray(length int, updates [][]int) []int {
	updateSum := make([]int, length)
	result := make([]int, length)

	for _, update := range updates {
		startIdx := update[0]
		endIdx := update[1]
		inc := update[2]

		updateSum[startIdx] += inc
		if endIdx < length - 1 { updateSum[endIdx + 1] -= inc }
	}
	
	prev := 0
	for i := 0; i < length; i++ {
		result[i] = prev + updateSum[i]
		prev = result[i]
	}

	return result
}

func TestGetModifiedArray1(t *testing.T) {
	result := getModifiedArray(5, [][]int{{1,3,2},{2,4,3},{0,2,-2}})
	answer := []int{-2,0,3,5,3}
	assert.Equal(t, answer, result)
}

func TestGetModifiedArray2(t *testing.T) {
	result := getModifiedArray(10, [][]int{{2,4,6},{5,6,8},{1,9,-4}})
	answer := []int{0,-4,2,2,2,4,4,-4,-4,-4}
	assert.Equal(t, answer, result)
}

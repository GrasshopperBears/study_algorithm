package leet56_test

import (
	"sort"
	"testing"

	"github.com/stretchr/testify/assert"
)

func merge(intervals [][]int) [][]int {
	result := [][]int{}

	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})

	result = append(result, intervals[0])
	last := 0

	for i := 1; i < len(intervals); i++ {
		if result[last][1] >= intervals[i][0] {
			if result[last][1] < intervals[i][1] {
				result[last][1] = intervals[i][1]
			}
		} else {
			result = append(result, intervals[i])
			last++
		}
	}
	return result
}

func TestMerge1(t *testing.T) {
	result := merge([][]int{{1,3},{2,6},{8,10},{15,18}})
	answer := [][]int{{1,6},{8,10},{15,18}}
	assert.Equal(t, answer, result)
}

func TestMerge2(t *testing.T) {
	result := merge([][]int{{1,4},{4,5}})
	answer := [][]int{{1,5}}
	assert.Equal(t, answer, result)
}

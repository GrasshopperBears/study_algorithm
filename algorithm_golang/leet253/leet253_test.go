package leet253_test

import (
	// "fmt"

	"sort"
	"testing"

	"github.com/stretchr/testify/assert"
)

func minMeetingRooms(intervals [][]int) int {
	meetingRooms := 0
	meetingNum := len(intervals)
	starts := []int{}
	ends := []int{}

	for _, interval := range intervals {
		starts = append(starts, interval[0])
		ends = append(ends, interval[1])
	}
	sort.Ints(starts)
	sort.Ints(ends)
	
	startIdx := 0
	endIdx := 0

	for ; startIdx < meetingNum; {
		if starts[startIdx] >= ends[endIdx] {
			endIdx++
		} else {
			meetingRooms++
		}
		startIdx++
	}

	return meetingRooms
}

func TestMinMeetingRooms1(t *testing.T) {
	result := minMeetingRooms([][]int{{0,30}, {5,10}, {15,20}})
	answer := 2
	assert.Equal(t, result, answer)
}

func TestMinMeetingRooms2(t *testing.T) {
	result := minMeetingRooms([][]int{{7, 10}, {2, 4}})
	answer := 1
	assert.Equal(t, result, answer)
}

func TestMinMeetingRooms3(t *testing.T) {
	result := minMeetingRooms([][]int{{1, 5}, {8, 9}, {8, 9}})
	answer := 2
	assert.Equal(t, result, answer)
}

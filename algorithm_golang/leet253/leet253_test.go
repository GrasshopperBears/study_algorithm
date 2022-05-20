package leet253_test

import (
	// "fmt"

	"sort"
	"testing"

	"github.com/stretchr/testify/assert"
)

func minMeetingRooms(intervals [][]int) int {
	var meetingRooms [][][]int

	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})

	for _, interval := range intervals {
		pushed := false
		start := interval[0]
		end := interval[1]
		for j := range meetingRooms {
			meetingRoom := &meetingRooms[j]
			for i, meeting := range *meetingRoom {
				if i == 0 && meeting[0] >= end {
					*meetingRoom = append((*meetingRoom)[:1], (*meetingRoom)[0:]...)
					(*meetingRoom)[0] = interval
					pushed = true
					break
				}
				if start >= meeting[1] {
					if i == len((*meetingRoom)) - 1 {
						*meetingRoom = append(*meetingRoom, interval)
						pushed = true
						break
					}
					if end <= (*meetingRoom)[i+1][0] {
						*meetingRoom = append((*meetingRoom)[:i+1], (*meetingRoom)[i:]...)
						(*meetingRoom)[i] = interval
						pushed = true
						break
					}
				}
			}
			if pushed { break }
		}
		if !pushed {
			meetingRooms = append(meetingRooms, [][]int{interval})
		}
	}

	return len(meetingRooms)
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

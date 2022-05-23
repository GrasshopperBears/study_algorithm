package leet506_test

import (
	"fmt"
	"testing"

	"github.com/stretchr/testify/assert"
)

type RankHeap struct {
	arr [][]int
	size int
}

func RankHeapConstructor(length int) RankHeap {
	rankHeap := RankHeap{}
	rankHeap.arr = make([][]int, length + 1)
	rankHeap.size = 0
	return rankHeap
}

func (rankHeap *RankHeap) RankHeapEnqueue(idx int, score int) {
	rankHeap.size++
	rankHeap.arr[rankHeap.size] = []int{idx, score}
	
	for i := rankHeap.size; i > 0; {
		parentIdx := i / 2
		if parentIdx < 1 || rankHeap.arr[parentIdx][1] >= score { break }
		rankHeap.arr[parentIdx][0], rankHeap.arr[parentIdx][1], rankHeap.arr[i][0], rankHeap.arr[i][1] =
			rankHeap.arr[i][0], rankHeap.arr[i][1], rankHeap.arr[parentIdx][0], rankHeap.arr[parentIdx][1]
		i = parentIdx
	}
}

func (rankHeap *RankHeap) RankHeapDequeue() int {
	rootIdx := rankHeap.arr[1][0]

	if rankHeap.size > 1 {
		rankHeap.arr[1][0], rankHeap.arr[1][1] = rankHeap.arr[rankHeap.size][0], rankHeap.arr[rankHeap.size][1]

		for i := 1;; {
			changeIdx := i
			if 2*i <= rankHeap.size && rankHeap.arr[changeIdx][1] < rankHeap.arr[2*i][1] { changeIdx = 2*i }
			if 2*i + 1 <= rankHeap.size && rankHeap.arr[changeIdx][1] < rankHeap.arr[2*i + 1][1] { changeIdx = 2*i + 1 }

			rankHeap.arr[i][0], rankHeap.arr[i][1], rankHeap.arr[changeIdx][0], rankHeap.arr[changeIdx][1] =
				rankHeap.arr[changeIdx][0], rankHeap.arr[changeIdx][1], rankHeap.arr[i][0], rankHeap.arr[i][1]
			
			if changeIdx == i { break }

			i = changeIdx
		}
	}
	rankHeap.size--
	return rootIdx
}

func getRankString(rank int) string {
	if rank == 1 { return "Gold Medal" }
	if rank == 2 { return "Silver Medal" }
	if rank == 3 { return "Bronze Medal" }
	return fmt.Sprint(rank)
}

func findRelativeRanks(scores []int) []string {
	rankHeap := RankHeapConstructor(len(scores))
	result := make([]string, len(scores))

	for i, score := range scores {
		rankHeap.RankHeapEnqueue(i, score)
	}

	for rank := 1; rankHeap.size > 0; rank++ {
		rankIdx := rankHeap.RankHeapDequeue()
		result[rankIdx] = getRankString(rank)
	}
	return result
}

func TestFindRelativeRanks1(t *testing.T) {
	result := findRelativeRanks([]int{5,4,3,2,1})
	answer := []string{"Gold Medal","Silver Medal","Bronze Medal","4","5"}
	assert.Equal(t, answer, result)
}

func TestFindRelativeRanks2(t *testing.T) {
	result := findRelativeRanks([]int{10,3,8,9,4})
	answer := []string{"Gold Medal","5","Bronze Medal","Silver Medal","4"}
	assert.Equal(t, answer, result)
}

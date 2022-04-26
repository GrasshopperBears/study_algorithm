package leet973_test

import (
	// "fmt"
	"math"
	"testing"

	"github.com/stretchr/testify/assert"
)

type DistNode struct {
	dist float64
	point []int
	next *DistNode
}

func kClosest(points [][]int, k int) [][]int {
	head := DistNode{0, []int{0, 0}, nil}
	cnt := 0
	max := 0.0

	for idx := 0; idx < len(points); idx++ {
		point := points[idx]
		dist := math.Sqrt(math.Pow(float64(point[0]), 2) + math.Pow(float64(point[1]), 2))

		if dist > max && cnt >= k { continue }

		cnt++
		if dist > max { max = dist }

		ptr := &head
		
		for ; ptr.next != nil; ptr = ptr.next {
			if ptr.next.dist > dist {
				break
			}
		}
		newNode := DistNode{dist, point, ptr.next}
		ptr.next = &newNode
	}

	var result [][]int

	for ptr := head.next; len(result) < k; ptr = ptr.next {
		result = append(result, ptr.point)
	}
	return result
}

func TestKClosest1(t *testing.T) {
	result := kClosest([][]int{{1,3},{-2,2}}, 1)
	answer := [][]int{{-2,2}}
	assert.Equal(t, answer, result)
}

func TestKClosest2(t *testing.T) {
	result := kClosest([][]int{{3,3},{5,-1},{-2,4}}, 2)
	answer := [][][]int{{{3,3},{-2,4}}, {{-2,4},{3,3}}}
	assert.Contains(t, answer, result)
}

package leet207_test

import (
	// "fmt"
	"testing"

	"github.com/stretchr/testify/assert"
)

func checkCycle(course int, dirGraph *[][]bool, visited *[]bool, currentSet *map[int]bool) bool {
	_, exist := (*currentSet)[course]
	if exist { return true }

	(*currentSet)[course] = true
	
	for i := range (*dirGraph)[course] {
		if (*dirGraph)[course][i] && !(*visited)[i] && checkCycle(i, dirGraph, visited, currentSet) {
			return true
		}
	}
	(*visited)[course] = true

	return false
}

func solveByCheckingCycle(numCourses int, prerequisites [][]int) bool {
	dirGraph := make([][]bool, numCourses)
	visited := make([]bool, numCourses)
	for i := range dirGraph {
		dirGraph[i] = make([]bool, numCourses)
	}

	for i := range dirGraph {
		for j := range dirGraph[0] {
			dirGraph[i][j] = false
		}
		visited[i] = false
	}

	for i := range prerequisites {
		prev := prerequisites[i][0]
		next := prerequisites[i][1]
		dirGraph[prev][next] = true
	}

	for i := range visited {
		if !visited[i] {
			currentSet := make(map[int]bool)
			if checkCycle(i, &dirGraph, &visited, &currentSet) {
				return false
			}
		}
	}

	return true
}

func solveByTopologicalSort(numCourses int, prerequisites [][]int) bool {
	incomeCnt := make([]int, numCourses)
	graph := make([][]int, numCourses)

	for i := range graph {
		graph[i] = []int{}
		incomeCnt[i] = 0
	}

	for i := range prerequisites {
		prev := prerequisites[i][0]
		next := prerequisites[i][1]
		graph[prev] = append(graph[prev], next)
		incomeCnt[next]++
	}

	queue := []int{}
	sorted := []int{}

	for i := range incomeCnt {
		if incomeCnt[i] == 0 {
			queue = append(queue, i)
		}
	}

	for ; len(queue) > 0; {
		current := queue[0]
		queue = queue[1:]
		sorted = append(sorted, current)

		nextCourses := graph[current]
		for i := range nextCourses {
			nextCourse := nextCourses[i]
			incomeCnt[nextCourse]--
			if incomeCnt[nextCourse] == 0 {
				queue = append(queue, nextCourse)
			}
		}
		graph[current] = []int{}
	}
	return len(sorted) == numCourses
}

func canFinish(numCourses int, prerequisites [][]int) bool {
	// return solveByCheckingCycle(numCourses, prerequisites)
	return solveByTopologicalSort(numCourses, prerequisites)
}

func TestCanFinish1(t *testing.T) {
	result := canFinish(2, [][]int{{1,0}})
	answer := true
	assert.Equal(t, answer, result)
}

func TestCanFinish2(t *testing.T) {
	result := canFinish(2, [][]int{{1,0}, {0,1}})
	answer := false
	assert.Equal(t, answer, result)
}

func TestCanFinish3(t *testing.T) {
	result := canFinish(2, [][]int{{0,1}})
	answer := true
	assert.Equal(t, answer, result)
}

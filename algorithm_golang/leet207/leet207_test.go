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

func canFinish(numCourses int, prerequisites [][]int) bool {
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

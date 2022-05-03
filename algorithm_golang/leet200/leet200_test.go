package leet200_test

import (
	// "fmt"
	"testing"

	"github.com/stretchr/testify/assert"
)

func visit(i int, j int, gridPtr *[][]byte) {
	grid := *gridPtr
	grid[i][j] = '0'
	if i > 0 && grid[i-1][j] == '1' { visit(i-1, j, gridPtr) }
	if i < len(grid) - 1 && grid[i+1][j] == '1' { visit(i+1, j, gridPtr) }
	if j > 0 && grid[i][j-1] == '1' { visit(i, j-1, gridPtr) }
	if j < len(grid[0]) - 1 && grid[i][j+1] == '1' { visit(i, j+1, gridPtr) }
}

func numIslands(grid [][]byte) int {
	islands := 0

	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == '1' {
				visit(i, j, &grid)
				islands++
			}
		}
	}
	return islands
}

func TestNumIslands1(t *testing.T) {
	var grid = [][]byte {
		{'1','1','1','1','0'},
		{'1','1','0','1','0'},
		{'1','1','0','0','0'},
		{'0','0','0','0','0'},
	}
	result := numIslands(grid)
	answer := 1
	assert.Equal(t, result, answer)
}

func TestNumIslands2(t *testing.T) {
	var grid = [][]byte {
		{'1','1','0','0','0'},
		{'1','1','0','0','0'},
		{'0','0','1','0','0'},
		{'0','0','0','1','1'},
	}
	result := numIslands(grid)
	answer := 3
	assert.Equal(t, result, answer)
}

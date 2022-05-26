package leet79_test

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func checkExist(boardPtr *[][]byte, word string, wordIdx int, row int, col int) bool {
	board := *boardPtr

	if wordIdx == len(word) { return true }
	if row < 0 || col < 0 || row == len(board) || col == len(board[0]) { return false }
	if board[row][col] == 0 || board[row][col] != word[wordIdx] { return false }

	save := board[row][col]
	board[row][col] = 0

	result := checkExist(boardPtr, word, wordIdx + 1, row + 1, col) ||
						checkExist(boardPtr, word, wordIdx + 1, row - 1, col) ||
						checkExist(boardPtr, word, wordIdx + 1, row, col + 1) ||
						checkExist(boardPtr, word, wordIdx + 1, row, col - 1)

	board[row][col] = save
	return result
}

func exist(board [][]byte, word string) bool {
	for row := 0; row < len(board); row++ {
		for col := 0; col < len(board[0]); col++ {
			if checkExist(&board, word, 0, row, col) { return true }
		}
	}
	return false
}

func TestExist1(t *testing.T) {
	result := exist([][]byte{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED")
	answer := true
	assert.Equal(t, answer, result)
}

func TestExist2(t *testing.T) {
	result := exist([][]byte{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE")
	answer := true
	assert.Equal(t, answer, result)
}

func TestExist3(t *testing.T) {
	result := exist([][]byte{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB")
	answer := false
	assert.Equal(t, answer, result)
}

package leet139_test

import (
	"strings"
	"testing"

	"github.com/stretchr/testify/assert"
)

func wordBreak(s string, wordDict []string) bool {
	visited := make([]bool, len(s))
	for i := range visited {
		visited[i] = false
	}

	for queue := []int{0}; len(queue) > 0; {
		current := queue[0]
		if current == len(s) { return true }
		queue = queue[1:]

		if visited[current] { continue }
		visited[current] = true

		for _, word := range wordDict {
			if strings.HasPrefix(s[current:], word) {
				queue = append(queue, current + len(word))
			}
		}
	}
	return false
}

func TestWordBreak1(t *testing.T) {
	result := wordBreak("leetcode", []string{"leet", "code"})
	answer := true
	assert.Equal(t, answer, result)
}

func TestWordBreak2(t *testing.T) {
	result := wordBreak("applepenapple", []string{"apple", "pen"})
	answer := true
	assert.Equal(t, answer, result)
}

func TestWordBreak3(t *testing.T) {
	result := wordBreak("catsandog", []string{"cats","dog","sand","and","cat"})
	answer := false
	assert.Equal(t, answer, result)
}

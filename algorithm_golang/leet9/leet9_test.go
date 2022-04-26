package leet9_test

import (
	// "fmt"
	"testing"

	"github.com/stretchr/testify/assert"
)

func isPalindrome(num int) bool {
	if num < 10 { return num >= 0 }

	digit := 0
	for bit := 1; bit <= num; bit *= 10 { digit++ }

	stackLen := digit / 2
	stack := make([]int, stackLen)
	i := 0
	current := num
	for ; i < stackLen; current /= 10 {
		lastDigit := current % 10
		stack[i] = lastDigit
		i++
		if (i == stackLen && digit % 2 == 1) { current /= 10 }
	}
	for ; current > 0; current /= 10 {
		lastDigit := current % 10
		i--
		if stack[i] != lastDigit { return false }
	}

	return true
}

func Test1(t *testing.T) {
	result := isPalindrome(121)
	answer := true
	assert.Equal(t, answer, result)
}

func Test2(t *testing.T) {
	result := isPalindrome(-121)
	answer := false
	assert.Equal(t, answer, result)
}

func Test3(t *testing.T) {
	result := isPalindrome(10)
	answer := false
	assert.Equal(t, answer, result)
}

func Test4(t *testing.T) {
	result := isPalindrome(1000021)
	answer := false
	assert.Equal(t, answer, result)
}

package leet20_test

import (
	// "fmt"
	"testing"
	"github.com/stretchr/testify/assert"
)

func isValid(s string) bool {
	var stack []rune

	for _, char := range s {
		stackLen := len(stack)
		if char == '(' || char == '{' || char == '[' {
			stack = append(stack, char)
		} else if stackLen == 0 {
			return false
		} else {
			last := stack[stackLen - 1]
			if (last == '(' && char == ')') || (last == '{' && char == '}') || (last == '[' && char == ']') {
				stack = stack[0 : stackLen - 1]
				continue
			}
			return false
		}
	}

	return len(stack) == 0
}

func TestIsValid1(t *testing.T) {
	result := isValid("()")
	answer := true
	assert.Equal(t, result, answer)
}
func TestIsValid2(t *testing.T) {
	result := isValid("()[]{}")
	answer := true
	assert.Equal(t, result, answer)
}
func TestIsValid3(t *testing.T) {
	result := isValid("(]")
	answer := false
	assert.Equal(t, result, answer)
}
func TestIsValid4(t *testing.T) {
	result := isValid("([)]")
	answer := false
	assert.Equal(t, result, answer)
}
func TestIsValid5(t *testing.T) {
	result := isValid("{[]}")
	answer := true
	assert.Equal(t, result, answer)
}
package leet1249_test

import (
	// "fmt"
	"testing"

	"github.com/stretchr/testify/assert"
)

func minRemoveToMakeValid(s string) string {
	balance := 0

	for idx := 0; idx < len(s); {
		current := s[idx]
		if current == '(' {
			balance++;
			idx++
		} else if current == ')' {
			if balance > 0 {
				balance--
				idx++
			} else {
				s = s[0 : idx] + s[idx + 1 :]
			}
		} else {
			idx++
		}
	}
	
	if balance > 0 {
		idx := len(s) - 1
		for ; balance > 0; idx-- {
			current := s[idx]
			if current == '(' {
				s = s[0 : idx] + s[idx + 1:]
				balance--
			}
		}
	}

	return s
}

func TestMinRemoveToMakeValid1(t *testing.T) {
	result := minRemoveToMakeValid("lee(t(c)o)de)")
	answer := "lee(t(c)o)de"
	assert.Equal(t, answer, result)
}

func TestMinRemoveToMakeValid2(t *testing.T) {
	result := minRemoveToMakeValid("a)b(c)d")
	answer := "ab(c)d"
	assert.Equal(t, answer, result)
}

func TestMinRemoveToMakeValid3(t *testing.T) {
	result := minRemoveToMakeValid("))((")
	answer := ""
	assert.Equal(t, answer, result)
}

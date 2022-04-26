package leet680_test

import (
	// "fmt"
	"testing"

	"github.com/stretchr/testify/assert"
)

func isPalindrome(s string) bool {
	for left, right := 0, len(s) - 1; left < right; {
		if s[left] != s[right] { return false }
		left++
		right--
	}
	return true
}

func validPalindrome(s string) bool {
	if (len(s) <= 2) { return true }

	for left, right := 0, len(s) - 1; left < right; {
		if s[left] == s[right] {
			left++
			right--
			continue
		}
		if isPalindrome(s[left + 1 : right + 1]) || isPalindrome(s[left : right]) { return true }
		return false
	}
	return true
}

func TestValistPalindrome1(t *testing.T) {
	result := validPalindrome("aba")
	answer := true
	assert.Equal(t, answer, result)
}

func TestValistPalindrome2(t *testing.T) {
	result := validPalindrome("abca")
	answer := true
	assert.Equal(t, answer, result)
}

func TestValistPalindrome3(t *testing.T) {
	result := validPalindrome("abc")
	answer := false
	assert.Equal(t, answer, result)
}

func TestValistPalindrome4(t *testing.T) {
	result := validPalindrome("aa")
	answer := true
	assert.Equal(t, answer, result)
}

func TestValistPalindrome5(t *testing.T) {
	result := validPalindrome("a")
	answer := true
	assert.Equal(t, answer, result)
}

func TestValistPalindrome6(t *testing.T) {
	result := validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga")
	answer := true
	assert.Equal(t, answer, result)
}

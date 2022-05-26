package leet17_test

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func getLetters(digit rune) []string {
	if digit == '2' { return []string{"a", "b", "c"} }
	if digit == '3' { return []string{"d", "e", "f"} }
	if digit == '4' { return []string{"g", "h", "i"} }
	if digit == '5' { return []string{"j", "k", "l"} }
	if digit == '6' { return []string{"m", "n", "o"} }
	if digit == '7' { return []string{"p", "q", "r", "s"} }
	if digit == '8' { return []string{"t", "u", "v"} }
	return []string{"w", "x", "y", "z"}
}

func letterCombinations(digits string) []string {
	result := []string{}

	for _, digit := range digits {
		currentLetters := getLetters(digit)
		newResult := []string{}

		if len(result) == 0 {
			result = currentLetters
			continue
		}
		for _, word := range result {
			for _, currentLetter := range currentLetters {
				newResult = append(newResult, word + string(currentLetter))
			}
		}
		result = newResult
	}
	return result
}

func TestLetterCombination1(t *testing.T) {
	result := letterCombinations("23")
	answer := []string{"ad","ae","af","bd","be","bf","cd","ce","cf"}
	assert.Equal(t, answer, result)
}

func TestLetterCombination2(t *testing.T) {
	result := letterCombinations("")
	answer := []string{}
	assert.Equal(t, answer, result)
}

func TestLetterCombination3(t *testing.T) {
	result := letterCombinations("2")
	answer := []string{"a","b","c"}
	assert.Equal(t, answer, result)
}

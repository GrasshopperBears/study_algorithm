package leet394_test

import (
	// "fmt"
	"strconv"
	"strings"
	"testing"

	"regexp"

	"github.com/stretchr/testify/assert"
)

func decodeString(s string) string {
	var countStack [] int
	var strStack [] string
	currentStr := ""
	numRegex, _ := regexp.Compile(`^[0-9]+\[`)
	strRegex, _ := regexp.Compile(`^[a-z]+`)
	
	for idx := 0; idx < len(s); {
		if s[idx] == ']' {
			lastCount := countStack[len(countStack) - 1]
			countStack = countStack[0 : len(countStack) - 1]
			currentStr = strings.Repeat(currentStr, lastCount)

			if len(strStack) > 0 {
				lastStr := strStack[len(strStack) - 1]
				strStack = strStack[0 : len(strStack) - 1]
				currentStr = lastStr + currentStr
			}
			idx++
			continue
		}

		numMatchResult := numRegex.FindString(s[idx :])
		if len(numMatchResult) > 0 {
			num, _ := strconv.Atoi(numMatchResult[0 : len(numMatchResult) - 1])

			countStack = append(countStack, num)
			strStack = append(strStack, currentStr)

			currentStr = ""
			idx += len(numMatchResult)
			continue
		}

		strMatchResult := strRegex.FindString(s[idx:])
		currentStr += strMatchResult
		idx += len(strMatchResult)
	}
	return currentStr
}

func TestDecodeString1(t *testing.T) {
	result := decodeString("3[a]2[bc]")
	answer := "aaabcbc"
	assert.Equal(t, answer, result)
}

func TestDecodeString2(t *testing.T) {
	result := decodeString("3[a2[c]]")
	answer := "accaccacc"
	assert.Equal(t, answer, result)
}

func TestDecodeString3(t *testing.T) {
	result := decodeString("2[abc]3[cd]ef")
	answer := "abcabccdcdcdef"
	assert.Equal(t, answer, result)
}

func TestDecodeString4(t *testing.T) {
	result := decodeString("abc3[cd]xyz")
	answer := "abccdcdcdxyz"
	assert.Equal(t, answer, result)
}

func TestDecodeString5(t *testing.T) {
	result := decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef")
	answer := "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"
	assert.Equal(t, answer, result)
}

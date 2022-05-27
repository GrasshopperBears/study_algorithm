package leet67_test

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func addBinaryString(a byte, b byte) []byte {
	if a != b { return []byte{'0', '1'} }
	if a == '0' { return []byte{'0', '0'} }
	return []byte{'1', '0'}
}

func addBinary(a string, b string) string {
	result := ""
	carry := byte('0')

	for i, j := len(a) - 1, len(b) - 1; i >= 0 || j >= 0; {
		one, two := byte('0'), byte('0')
		if i >= 0 { one = a[i] }
		if j >= 0 { two = b[j] }

		addResult1 := addBinaryString(one, two)
		addResult2 := addBinaryString(addResult1[1], carry)
		carry = addBinaryString(addResult1[0], addResult2[0])[1]
		result = string(addResult2[1]) + result

		i--
		j--
	}
	if carry == '1' { result = "1" + result }

	return result
}

func TestAddBinary1(t *testing.T) {
	result := addBinary("11", "1")
	answer := "100"
	assert.Equal(t, answer, result)
}

func TestAddBinary2(t *testing.T) {
	result := addBinary("1010", "1011")
	answer := "10101"
	assert.Equal(t, answer, result)
}

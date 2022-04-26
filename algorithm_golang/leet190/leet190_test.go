package leet190_test

import (
	// "fmt"
	"testing"

	"github.com/stretchr/testify/assert"
)

func reverseBits(num uint32) uint32 {
	var ans uint32 = 0
	var mask uint32 = 1

	for ; mask > 0; mask <<= 1 {
		ans <<= 1
		if num & mask > 0 { ans += 1 }
	}
	return ans
}

func TestReverseBits1(t *testing.T) {
	result := reverseBits(43261596)
	var answer uint32 = 964176192
	assert.Equal(t, answer, result)
}

func TestReverseBits2(t *testing.T) {
	result := reverseBits(4294967293)
	var answer uint32 = 3221225471
	assert.Equal(t, answer, result)
}

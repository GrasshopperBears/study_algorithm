package leet50_test

import (
	// "fmt"
	"testing"

	"github.com/stretchr/testify/assert"
)

func myPow(x float64, n int) float64 {
	var ans float64 = x
	current := 1

	if n == 0 {
		return 1
	} else if n < 0 {
		return myPow(1/x, -n)
	}

	for ; current * 2 <= n; current *= 2 {
		ans *= ans
	}
	return ans * myPow(x, n - current)
}

func TestMyPow1(t *testing.T) {
	result := myPow(2.00000, 10)
	answer := 1024.00000
	assert.Equal(t, answer, result)
}

func TestMyPow2(t *testing.T) {
	result := myPow(2.10000, 3)
	answer := 9.26100
	assert.Equal(t, answer, result)
}

func TestMyPow3(t *testing.T) {
	result := myPow(2.00000, -2)
	answer := 0.25000
	assert.Equal(t, answer, result)
}

package leet716_test

import (
	// "fmt"
	"testing"

	"github.com/stretchr/testify/assert"
)

type Node struct {
	value int
	maxPrev *Node
	maxNext *Node
	stackPrev *Node
	stackNext *Node
}

type MaxStack struct {
	stack *Node
	max *Node
}


func Constructor() MaxStack {
  stack := MaxStack{}
	stack.stack = nil
	stack.max = nil

	return stack
}


func (this *MaxStack) Push(x int)  {
	newNode := Node{x, nil, nil, nil, nil}
  newNode.stackPrev = this.stack

	if this.stack != nil {
		this.stack.stackNext = &newNode
	}
	this.stack = &newNode

	if this.max == nil || x >= this.max.value {
		newNode.maxNext = this.max
		this.max = &newNode
		return
	}

	ptr := this.max
	for ; ptr.maxNext != nil; ptr = ptr.maxNext {
		if x >= ptr.maxNext.value { break }
	}
	if ptr.maxNext != nil {
		ptr.maxNext.maxPrev = &newNode
		newNode.maxNext = ptr.maxNext
	}
	ptr.maxNext = &newNode
	newNode.maxPrev = ptr
}


func (this *MaxStack) Pop() int {
	last := this.stack
	this.stack = last.stackPrev

	if this.stack != nil {
		this.stack.stackNext = nil
	}

	if last == this.max {
		this.max = last.maxNext
		if this.max != nil {
			this.max.maxPrev = nil
		}
	} else {
		if last.maxPrev != nil {
			last.maxPrev.maxNext = last.maxNext
		}
		if last.maxNext != nil {
			last.maxNext.maxPrev = last.maxPrev
		}
	}

	return last.value
}


func (this *MaxStack) Top() int {
  return this.stack.value
}


func (this *MaxStack) PeekMax() int {
  return this.max.value
}


func (this *MaxStack) PopMax() int {
  last := this.max

	this.max = last.maxNext

	if this.max != nil {
		this.max.maxPrev = nil
	}

	if last == this.stack {
		this.stack = last.stackPrev
		if this.stack != nil {
			this.stack.stackNext = nil
		}
	} else {
		if last.stackNext != nil {
			last.stackNext.stackPrev = last.stackPrev
		}
		if last.stackPrev != nil {
			last.stackPrev.stackNext = last.stackNext
		}
	}

	return last.value
}

func TestMaxStack1(t *testing.T) {
	maxStack := Constructor()
	maxStack.Push(5)
	maxStack.Push(1)
	maxStack.Push(5)
	assert.Equal(t, maxStack.Top(), 5)
	assert.Equal(t, maxStack.PopMax(), 5)
	assert.Equal(t, maxStack.Top(), 1)
	assert.Equal(t, maxStack.PeekMax(), 5)
	assert.Equal(t, maxStack.Pop(), 1)
	assert.Equal(t, maxStack.Top(), 5)
}

func TestMaxStack2(t *testing.T) {
	maxStack := Constructor()
	maxStack.Push(5)
	assert.Equal(t, maxStack.PeekMax(), 5)
	assert.Equal(t, maxStack.Pop(), 5)
}

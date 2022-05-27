package leet1166_test

import (
	"strings"
	"testing"

	"github.com/stretchr/testify/assert"
)

type FileNode struct {
	name string
	val int
	childs []*FileNode
}

type FileSystem struct {
  root *FileNode
}


func Constructor() FileSystem {
  fileSystem := FileSystem{}
	rootNode := []*FileNode{}
	fileSystem.root = &FileNode{"", 0, rootNode}
	return fileSystem
}

func findChild(fileNode *FileNode, childName string) *FileNode {
	for _, childNode := range fileNode.childs {
		if childNode.name == childName { return childNode }
	}
	return nil
}

func (this *FileSystem) CreatePath(path string, value int) bool {
  tokens := strings.Split(path, "/")
	current := this.root

	for i, str := range tokens {
		if i == 0 {
			if len(str) > 0 { return false }
			continue
		}
		if len(str) == 0 { return false }

		findResult := findChild(current, str)
		
		if i == len(tokens) - 1 {
			if findResult != nil { return false }
			newChild := FileNode{str, value, []*FileNode{}}
			current.childs = append(current.childs, &newChild)
		} else {
			if findResult == nil { return false }
			current = findResult
		}
	}
	return true
}


func (this *FileSystem) Get(path string) int {
  tokens := strings.Split(path, "/")
	current := this.root

	for i, str := range tokens {
		if i == 0 {
			if len(str) > 0 { return -1 }
			continue
		}
		if len(str) == 0 { return -1 }
		
		findResult := findChild(current, str)
		if findResult == nil { return -1 }
		current = findResult
	}
	return current.val
}

func TestFileSystem1(t *testing.T) {
	fileSystem := Constructor()
	assert.Equal(t, true, fileSystem.CreatePath("/a",1))
	assert.Equal(t, 1, fileSystem.Get("/a"))
}

func TestFileSystem2(t *testing.T) {
	fileSystem := Constructor()
	assert.Equal(t, true, fileSystem.CreatePath("/leet",1))
	assert.Equal(t, true, fileSystem.CreatePath("/leet/code",2))
	assert.Equal(t, 2, fileSystem.Get("/leet/code"))
	assert.Equal(t, false, fileSystem.CreatePath("/c/d",1))
	assert.Equal(t, -1, fileSystem.Get("/c"))
}

package leet938_test

type TreeNode struct {
  Val int
  Left *TreeNode
  Right *TreeNode
}

func rangeSumBST(root *TreeNode, low int, high int) int {
  result := 0
  queue := []*TreeNode{}
  queue = append(queue, root)
  
  for ; len(queue) > 0; {
    current := queue[0]
    queue = queue[1:]
    
    if current == nil { continue }
    
    if current.Val >= low && current.Val <= high {
      result += current.Val
      queue = append(queue, current.Left)
      queue = append(queue, current.Right)
    } else if current.Val < low {
      queue = append(queue, current.Right)
    } else if current.Val > high {
      queue = append(queue, current.Left)
    }
  }
  
  return result
}

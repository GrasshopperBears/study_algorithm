use std::borrow::Borrow;
use std::rc::Rc;
use std::cell::RefCell;

#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
  pub val: i32,
  pub next: Option<Box<ListNode>>
}

impl ListNode {
  #[inline]
  fn new(val: i32) -> Self {
    ListNode {
      next: None,
      val
    }
  }
}
// Definition for a binary tree node.
#[derive(Debug, PartialEq, Eq)]
pub struct TreeNode {
  pub val: i32,
  pub left: Option<Rc<RefCell<TreeNode>>>,
  pub right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
  #[inline]
  pub fn new(val: i32) -> Self {
    TreeNode {
      val,
      left: None,
      right: None
    }
  }
}

// pub fn helper(head: &Option<Box<ListNode>>, curr: &Option<Box<ListNode>>, root: &Option<Rc<RefCell<TreeNode>>>) -> bool {
//   if head.is_none() {
//     return true;
//   }
//   if root.is_none() {
//     return head.is_none();
//   }
//   let root_val = root.as_ref().unwrap().borrow().val;
//   let left = &root.as_ref().unwrap().borrow().left;
//   let right = &root.as_ref().unwrap().borrow().right;

//   if let Some(node) = curr {
//     if root_val == node.val {
//       if !left.is_none() && helper(head, &node.next, &left) {
//         return true;
//       }
//       if !right.is_none() && helper(head, &node.next, &right) {
//         return true;
//       }
//     }
//   }
//   if let Some(node) = head {
//     if root_val == node.val {
//       if !left.is_none() && helper(head, &node.next, &left) {
//         return true;
//       }
//       if !right.is_none() && helper(head, &node.next, &right) {
//         return true;
//       }
//     }
//   }
//   false
// }

pub fn dfs(root: Option<&Rc<RefCell<TreeNode>>>, mut i: usize, head_err: &Vec<usize>, fail: &Vec<usize>) -> bool {
  if root.is_none() { return false; }
  loop {
    if i == 0 || root.as_ref().unwrap().borrow_mut().val == head_err[i] as i32 { break; }
    i = fail[i - 1];
  }
  i += (root.as_ref().unwrap().borrow_mut().val == head_err[i] as i32) as usize;
  i == fail.len() || dfs(root.as_ref().unwrap().borrow_mut().left.as_ref(), i, head_err, fail) || dfs(root.as_ref().unwrap().borrow_mut().right.as_ref(), i, head_err, fail)
}

pub fn is_sub_path(head: Option<Box<ListNode>>, root: Option<Rc<RefCell<TreeNode>>>) -> bool {
  let mut head_arr: Vec<usize> = vec![head.as_ref().unwrap().val as usize];
  let mut fail = vec![0];
  let mut i = 0;
  let mut node = head.unwrap().next;

  loop {
    if node.is_none() { break; }
    loop {
      if i == 0 || node.as_ref().unwrap().val == head_arr[i] as i32 { break; }
      i = fail[i];
    }
    i += (node.as_ref().unwrap().val == head_arr[i] as i32) as usize;
    head_arr.push(node.as_ref().unwrap().val.clone() as usize);
    fail.push(i);
    node = node.unwrap().next;
  }

  dfs(root.as_ref(), 0, &head_arr, &fail)
}

pub fn test() {
  // let tree = TreeNode::new(1);
  // // let nodes = [TreeNode::new(4), TreeNode::new(2), TreeNode::new(1),
  // //   TreeNode::new(4), TreeNode::new(2), TreeNode::new(6), TreeNode::new(8), TreeNode::new(1), TreeNode::new(8),
  // // ];
  // let mut child = TreeNode::new(1);
  // let mut parent = TreeNode::new(2);
  // parent.left = child;
  // child = parent;
  // parent = TreeNode::new(4);
  // parent.right = Some(Rc::new(child));
  // child = parent;
  // tree.left = parent;

}

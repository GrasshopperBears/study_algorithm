class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None


class Solution(object):
    def buildTree(self, inorder, postorder):
        if not len(inorder):
            return None

        result = TreeNode(val=postorder[-1])
        idx = inorder.index(postorder[-1])
        self.postorder = postorder[:-1]
        result.right = self.buildTree(inorder[idx + 1:], self.postorder)
        result.left = self.buildTree(inorder[0:idx], self.postorder)

        return result


solution = Solution()
solution.buildTree(inorder=[9,3,15,20,7], postorder=[9,15,7,20,3])
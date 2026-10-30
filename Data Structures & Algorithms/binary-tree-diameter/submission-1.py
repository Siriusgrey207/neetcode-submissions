# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.res = 0

        # Returns the height of the three
        def dfs(curr):
            if not curr:
                return 0
            
            leftHeight = dfs(curr.left)
            rightHeight = dfs(curr.right)

            self.res = max(self.res, leftHeight + rightHeight)
            return 1 + max(leftHeight, rightHeight)

        dfs(root)
        return self.res

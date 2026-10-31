# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        
        def dfs(curr: Optional[TreeNode]) -> [bool, int]:
            if not curr: return [True, 0]

            leftTree = dfs(curr.left)
            rightTree = dfs(curr.right)

            isBalanced = (leftTree[0] and rightTree[0] and abs(leftTree[1] - rightTree[1]) <= 1)

            return [isBalanced, 1 + max(leftTree[1], rightTree[1])]
        
        return dfs(root)[0]
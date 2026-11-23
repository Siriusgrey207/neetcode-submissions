# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        
        def dfs(node, maxValue):
            # An empty tree has no good nodes.
            if not node:
                return 0
            
            res = 1 if node.val >= maxValue else 0
            maxValue = max(maxValue, node.val)

            # Add the number of good nodes from the left and right subtrees
            res += dfs(node.left, maxValue)
            res += dfs(node.right, maxValue)
            return res
        
        return dfs(root, root.val)


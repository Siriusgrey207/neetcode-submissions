# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        nodes = []

        def dfs(node: Optional[TreeNode], arr):
            if not node:
                return
            
            dfs(node.left, arr)
            nodes.append(node.val)
            dfs(node.right, arr)

        dfs(root, nodes);
        return nodes[k - 1]
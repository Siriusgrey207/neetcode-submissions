# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        def validNode(node, left, right):
            if not node:
                return True
            
            # Ensure the current node's value is within the boundaries
            if not (node.val < right and node.val > left):
                return False
            
            return (validNode(node.left, left, node.val) and
                    validNode(node.right, node.val, right))
        
        return validNode(root, float("-inf"), float("+inf"))



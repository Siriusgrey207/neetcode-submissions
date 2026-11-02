# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if p == None and q == None:
            return True
        if p == None and q != None:
            return False
        if p != None and q == None:
            return False

        # If the values at the current branch are not the same, return false.
        if p.val != q.val:
            return False

        # If they are the same, we want to recursively compare the lower branches.
        leftBranchesSame = self.isSameTree(p.left, q.left)
        rightBranchesSame = self.isSameTree(p.right, q.right)

        return True if leftBranchesSame and rightBranchesSame else False
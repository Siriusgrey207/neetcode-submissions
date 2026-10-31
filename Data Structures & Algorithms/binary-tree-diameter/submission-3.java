/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int res;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode curr) {
        // If the current node is null, return 0 (no depth to add).
        if (curr == null) return 0;

        // Recursive call to dfs to find the depth of the left and right branches.
        int left = dfs(curr.left);
        int right = dfs(curr.right);
        
        // Update the neW max With if necessary
        res = Math.max(res, left + right);
        return 1 + Math.max(left, right);
    }
}

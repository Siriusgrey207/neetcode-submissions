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
    public boolean isBalanced(TreeNode root) {
        return dfs(root).getKey();
    }

    private Pair<Boolean, Integer> dfs(TreeNode curr) {
        if (curr == null) return new Pair<>(true, 0);

        Pair<Boolean, Integer> leftBranch = dfs(curr.left);
        Pair<Boolean, Integer> rightBranch = dfs(curr.right);
        boolean balanced = (leftBranch.getKey() && rightBranch.getKey() && Math.abs(leftBranch.getValue() - rightBranch.getValue()) <= 1);

        int height = 1 + Math.max(leftBranch.getValue(), rightBranch.getValue());
        return new Pair<>(balanced, height);
    }
}

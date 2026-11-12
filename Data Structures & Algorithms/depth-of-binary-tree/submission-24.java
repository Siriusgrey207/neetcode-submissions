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
    public int maxDepth(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.offer(new Pair<>(root, 1));
        int res = 0;

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.poll();
            TreeNode node = pair.getKey();
            int depth = pair.getValue();

            if (node != null) {
                res = Math.max(res, depth);
                stack.offer(new Pair<>(node.left, depth + 1));
                stack.offer(new Pair<>(node.right, depth + 1));
            }
        }

        return res;
    }
}

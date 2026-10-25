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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode current = root;

        while (current != null || !nodeStack.isEmpty()) {
            while (current != null) {
                nodeStack.add(current);
                current = current.left;
            }

            current = nodeStack.pop();
            res.add(current.val);
            current = current.right;
        }

        return res;
    }
}
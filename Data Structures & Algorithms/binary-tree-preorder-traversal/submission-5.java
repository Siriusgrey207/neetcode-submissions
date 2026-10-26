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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null || !nodeStack.isEmpty()) {
            if (curr != null) {
                res.add(curr.val);
                nodeStack.add(curr.right);
                curr = curr.left;
            } else {
                curr = nodeStack.pop();
            }
        }

        return res;
    }
}
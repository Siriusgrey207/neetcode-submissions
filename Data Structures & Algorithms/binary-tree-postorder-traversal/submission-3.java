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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>() {{ push(root); }};
        Stack<Boolean> visited = new Stack<>() {{ push(false); }};
        List<Integer> res = new ArrayList<>();

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            Boolean hasBeenVisited = visited.pop();

            if (current != null) {
                if (hasBeenVisited) {
                    res.add(current.val);

                }  else {
                    stack.push(current);
                    visited.push(true);

                    stack.push(current.right);
                    visited.push(false);

                    stack.push(current.left);
                    visited.push(false);
                }
            }
        }

        return res;
    }
}
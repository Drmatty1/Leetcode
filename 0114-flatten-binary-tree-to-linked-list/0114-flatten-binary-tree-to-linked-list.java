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
    TreeNode sol(TreeNode root){
        if(root==null) return null;
        if(root.left == null && root.right == null) return root;

        TreeNode leftTail = sol(root.left);
        TreeNode rightTail = sol(root.right);
        if(leftTail==null) return rightTail;
        if(rightTail==null){
            root.right = root.left;
            root.left = null;
            return leftTail;
        }

        TreeNode leftHead = root.left;
        TreeNode rightHead = root.right;

        leftTail.right = rightHead;

        root.right = leftHead;
        root.left = null;

        return rightTail;
    }
    public void flatten(TreeNode root) {
        root = sol(root);
    }
}
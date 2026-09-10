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
    int ans = 0;
    int[] sol(TreeNode root){
        if(root == null) return new int[]{0,0};

        int[] L = sol(root.left);
        int[] R = sol(root.right);
        int avg = (L[0]+R[0]+root.val)/(1+L[1]+R[1]);
        if(avg == root.val ) ans++;

        return new int[]{L[0]+R[0]+root.val,1 + L[1]+R[1]};
    }
    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        sol(root);
        return ans;
    }
}
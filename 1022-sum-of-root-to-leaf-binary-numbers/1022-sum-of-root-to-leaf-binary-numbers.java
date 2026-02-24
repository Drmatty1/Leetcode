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
    void solve(TreeNode root,int temp, int[]ans){
        if( root == null ) return ;
        if( root.left == null && root.right == null ){
            temp = (temp<<1)|(root.val);
            ans[0] += temp;
            return;
        }
        temp = (temp<<1)|(root.val);
        solve(root.left,temp,ans);
        solve(root.right,temp,ans);
        return ;
    }
    public int sumRootToLeaf(TreeNode root) {
        int[] ans={0};
        solve(root,0,ans);
        return ans[0];
    }
}
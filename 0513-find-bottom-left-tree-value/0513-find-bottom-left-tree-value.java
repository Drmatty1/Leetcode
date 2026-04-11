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
     void sol(int l, TreeNode r, int []ans){
        if( r == null  ) return;
        if( l > ans[1] ){
            ans[0]=r.val;
            ans[1]=l;
        }
        sol(l+1,r.left,ans);
        sol(l+1,r.right,ans);
    }
    public int findBottomLeftValue(TreeNode root) {
        int []ans = {0,0};
        sol(1,root,ans);
        return ans[0];
    }
}
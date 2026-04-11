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
    void sol(int l, TreeNode r, List<Integer>ans){
        if( r == null  )return;
        if( l > ans.size() ){
            ans.add(r.val);
        }
        sol(l+1,r.right,ans);
        sol(l+1,r.left,ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>ans = new ArrayList<>();
        sol(1,root,ans);
        return ans;
    }
}
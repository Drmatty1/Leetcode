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
    String sol( TreeNode r ){

        if( r == null ) return "";
        if( r.left==null && r.right==null ) return (r.val+"");

        String a = sol(r.left);
        String b = sol(r.right);
        
        String curr ;
        if( r.right == null ){
            curr = r.val+"("+a+")";
        }
        else curr = r.val+"("+a+")("+b+")";

        return curr;

    }

    public String tree2str(TreeNode root) {
        return sol(root);
    }
}
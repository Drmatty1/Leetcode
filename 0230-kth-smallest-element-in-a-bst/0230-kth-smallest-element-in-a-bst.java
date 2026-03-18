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
    int inorder( TreeNode root, int []k ){
        
        if( root == null ) return -1;

        int a = inorder( root.left, k );
        if( a != -1 ) return a;

        k[0]--;
        if( k[0] == 0 ) return root.val;

        int b = inorder( root.right, k );
        if( b != -1 ) return b;

        return -1;
    }
    public int kthSmallest(TreeNode root, int k) {
        int []a = {k};
        return inorder( root, a );
    }
}
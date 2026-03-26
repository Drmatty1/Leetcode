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
   
    List<TreeNode> sol(int l, int r,  List<TreeNode> ans){
        
        List<TreeNode> curr = new ArrayList<>();
        
        if( l > r ){
            curr.add(null);
            return curr;
        } 

        for( int k = l; k<=r; k++ ){

            List<TreeNode> a = sol(l, k-1, ans);
            List<TreeNode> b = sol(k+1, r, ans);
            for( TreeNode p : a ){
                for( TreeNode q : b ){
                    TreeNode res = new TreeNode(k);
                    res.left = p;
                    res.right = q;
                    ans.add(res);
                    curr.add(res);
                }
            }
            
        }
        
        return curr;
    }
    
    List<TreeNode> sol1(int l, int r,  List<TreeNode> ans, Map<Integer, List<TreeNode>> dp){
        
        List<TreeNode> curr = new ArrayList<>();
        
        if( l > r ){
            curr.add(null);
            return curr;
        }
        
        int key  = (l<<4)|r;
        if( dp.containsKey(key) ) return dp.get(key);

        for( int k = l; k<=r; k++ ){

            List<TreeNode> a = sol1(l, k-1, ans, dp);
            List<TreeNode> b = sol1(k+1, r, ans, dp);
            for( TreeNode p : a ){
                for( TreeNode q : b ){
                    TreeNode res = new TreeNode(k);
                    res.left = p;
                    res.right = q;
                    ans.add(res);
                    curr.add(res);
                }
            }
            
        }
        
        dp.put(key, curr);
        return curr;
    }
    public List<TreeNode> generateTrees(int n) {

        // List<TreeNode> ans = new ArrayList<>();
        // return sol(1, n, ans);

        List<TreeNode> ans = new ArrayList<>();
        Map<Integer, List<TreeNode>> dp = new HashMap<>();
        return sol1(1, n, ans, dp);
        
    }
}
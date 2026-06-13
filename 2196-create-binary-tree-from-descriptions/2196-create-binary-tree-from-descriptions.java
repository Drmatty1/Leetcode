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
    private static final TreeNode[] res = new TreeNode[100001];
    public TreeNode createBinaryTree(int[][] descriptions) {
        int n = descriptions.length;
    //    List<TreeNode> res = new ArrayList<>(
    //     Collections.nCopies(100001,null));

        // TreeNode[]res = new TreeNode[100001];

        for (int[] x : descriptions) {
            res[x[0]] = null;
            res[x[1]] = null;
        }

        int root = 0;

        for(int []a: descriptions){
            int p = a[0], c = a[1], isLeft = a[2];
            if(res[p] == null){
                res[p] = new TreeNode(p);
                root ^= p;
            } 
            if(res[c] == null){
                res[c] = new TreeNode(c);
                root ^= c;
            } 
            
            if(isLeft == 1)  res[p].left = res[c];
            else  res[p].right = res[c];
            
            root ^= a[1];
        }

        // Root finder #1
        // Set<Integer> set = new HashSet<>();
        // for(int []a: descriptions) set.add(a[0]);
        // for(int []a: descriptions){
        //     int toRem = a[1];
        //     if(set.contains(toRem)) set.remove(toRem);
        // }

        
        // int a = -1;
        // for( int e: set) a = e;
        //    -- Or
        // int a = set.iterator().next();

        return res[root];

    }
}
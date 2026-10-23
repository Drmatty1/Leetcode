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
    static class Pair {
        int val;
        int originalIdx;

        Pair(int val, int originalIdx) {
            this.val = val;
            this.originalIdx = originalIdx;
        }
    }

    public int count(List<Integer> arr) {
        int n = arr.size();
        List<Pair> pairs = new ArrayList<>(n);

        // Store each element alongside its original index
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(arr.get(i), i));
        }

        // Sort elements by their value to know their target positions
        pairs.sort(Comparator.comparingInt(p -> p.val));

        boolean[] visited = new boolean[n];
        int totalSwaps = 0;

        for (int i = 0; i < n; i++) {
            // Skip if element is already visited or already in the correct position
            if (visited[i] || pairs.get(i).originalIdx == i) {
                continue;
            }

            // Find the length of the permutation cycle
            int cycleSize = 0;
            int curr = i;

            while (!visited[curr]) {
                visited[curr] = true;
                curr = pairs.get(curr).originalIdx;
                cycleSize++;
            }

            // A cycle of length L requires (L - 1) swaps to resolve
            if (cycleSize > 1) {
                totalSwaps += (cycleSize - 1);
            }
        }

        return totalSwaps;
    }
    public int minimumOperations(TreeNode root) {

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);
        int ans = 0;

        while (!queue.isEmpty()) {

            int s = queue.size();
            List<Integer> arr = new ArrayList<>();

            while(s-->0){
                
                TreeNode curr = queue.poll();
                if(curr.left != null){
                    arr.add(curr.left.val);
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    arr.add(curr.right.val);
                    queue.add(curr.right);
                }
            }
            ans += count(arr);
        }
        return ans;
    }
}
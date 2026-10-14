class Solution {
    int sol(int[] arr1, int[] arr2) {
        int maxDiff = 0;
        int n = arr1.length;
        int[][] signs = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        for (int[] s : signs) {   

            int minVal = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {

                int s1 = s[0], s2 = s[1];
                int cur = s1 * arr1[i] + s2 * arr2[i] + i;
                minVal = Math.min(minVal, cur);
                maxDiff = Math.max(maxDiff, cur - minVal);
            } 
        }
        
        return maxDiff;
    }
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        return sol(arr1, arr2);
    }
}
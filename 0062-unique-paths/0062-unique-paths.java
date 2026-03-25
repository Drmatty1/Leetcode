class Solution {
    public int uniquePaths(int m, int n) {
        int []next = new int[n+1];
        next[n-1] = 1;
        for( int i=m-1; i>=0; i-- ){
            int[] curr = new int[n+1];
            for( int j=n-1; j>=0; j-- ){
                curr[j] = curr[j+1]+next[j];
            }
            next = curr;
        }
        return next[0];
    }
}
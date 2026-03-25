class Solution {
    int sol(int n){
        if( n == 0 ) return 1;
        int ans = 0;
        for( int k = 1; k<=n; k++ ){
            ans += sol(k-1)*sol(n-k);
        }
        return ans;
    }
    int sol1(int n, int[]dp){
        if( n == 0 ) return 1;
        
        if( dp[n] != 0 ) return dp[n];
        
        int ans = 0;
        for( int k = 1; k<=n; k++ ){
            ans += sol1(k-1,dp)*sol1(n-k,dp);
        }
        return dp[n] = ans;
    }
    public int numTrees(int n) {
        // return sol(n);

        int []dp = new int[n+1];
        return sol1(n,dp);
    }
}   

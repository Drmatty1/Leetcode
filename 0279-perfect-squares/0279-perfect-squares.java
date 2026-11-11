class Solution {
    int []dp;
    int sol(int n, int []a){
        if(n==0) return 0;
        if(dp[n] != -1) return dp[n];
        int ans = Integer.MAX_VALUE;
        for(int E: a){
            if(E>n) break;
            ans = Math.min(ans,1+sol(n-E,a));
        }
        return dp[n] = ans;
    }
    public int numSquares(int n) {
        int m = (int)Math.sqrt(n);
        int []a = new int[m];
        for(int i=1; i<=m; i++) a[i-1] = i*i;

        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return sol(n,a);
    }
}
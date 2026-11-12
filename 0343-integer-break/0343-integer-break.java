class Solution {
    int []dp ;
    int sol(int n){
        if(n==2) return 1;
        if(dp[n] != 0) return dp[n];
        int res = 1;
        for(int i=1; i<n; i++){
            int temp = Math.max(i*(n-i),i*sol(n-i));
            res = Math.max(res, temp);
        }
        return dp[n] = res;
    }
    public int integerBreak(int n) {
        dp = new int[n+1];
        return sol(n);
    }
}
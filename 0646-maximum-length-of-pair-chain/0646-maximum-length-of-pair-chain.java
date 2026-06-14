class Solution {
    int sol(int [][]p , int idx, int prev, int [][]dp) {
        if(idx == p.length) return 0;
        if(dp[idx][prev+1001] != -1 )return dp[idx][prev+1001];
        int ans = 0;
        if( p[idx][0] > prev ) ans = 1+sol(p,idx+1,p[idx][1],dp);
        ans = Math.max(ans,sol(p,idx+1,prev,dp));
        return dp[idx][prev+1001] = ans;
    }
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->Integer.compare(a[1],b[1]));
        int n = pairs.length;
        int [][]dp = new int[n][2002];
        for(int i=0; i<n; i++)Arrays.fill(dp[i],-1);
        return sol(pairs,0,-1001,dp);
    }
}
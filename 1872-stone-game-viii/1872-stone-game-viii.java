class Solution {
    int []pre;
    int n;
    int [][]dp ;

    int sol(int []a, int i,boolean start){
        if(i==n-1) return pre[i+1];
        if(dp[i][start?1:0]!=Integer.MIN_VALUE) return dp[i][start?1:0];
        int max = sol(a,i+1,true);
        if(start) 
            max = Math.max(max,pre[i+1]-sol(a,i,false));

        return dp[i][start?1:0] = max;
    }
    public int stoneGameVIII(int[] stones) {
        n = stones.length;
        pre = new int[n+1];
        for(int i=0; i<n; i++) pre[i+1] = pre[i]+stones[i];

        dp = new int[n][2];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        return sol(stones,0,false);
    }
}
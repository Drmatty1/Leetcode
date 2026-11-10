class Solution {
    int []a;
    int n;
    int []dp ;
    int sol(int i){
        if(i==n) return 0;
        int cost = Integer.MAX_VALUE;
        if(dp[i] != -1) return dp[i];
        for(int j=i+1; j<=i+3 && j<=n; j++){
            cost = Math.min(cost, a[j-1]+(j-i)*(j-i)+sol(j));
            // System.out.println(i+" "+j+" "+cost);
        }
        return dp[i] = cost;
    }
    public int climbStairs(int n, int[] costs) {
        a = costs;
        this.n = n;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return sol(0);
    }
}
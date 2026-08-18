class Solution {
    int[] a;
    int n;
    int [][]dp;

    int sol(int i, int j){
        
        if(i+1==j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int score = 0;
        for(int k=i+1; k<j; k++){
            int curr = a[i]*a[k]*a[j] + sol(i,k) + sol(k,j);
            score = Math.max(score,curr);
        }

        return dp[i][j] = score;
        
    }
    public int maxCoins(int[] nums) {
        n = nums.length;
        a = new int[n+2];

        a[0] = 1;
        a[n+1] = 1;
        for(int i=0; i<nums.length; i++) a[i+1] = nums[i];

        dp = new int[n+2][n+2];
        for(int i=0; i<n+2; i++) Arrays.fill(dp[i],-1);
        return sol(0,n+1);
    }
}
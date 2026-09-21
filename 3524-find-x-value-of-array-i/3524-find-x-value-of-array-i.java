class Solution {
    long[][] dp;
    int []arr;
    int n,k;
    long[] ans;

    long[] sol(int i){
        if(i==n) return new long[k];

        if(dp[i] != null) return dp[i];

        long []next = sol(i+1);
        long []curr = new long[k];

        curr[arr[i]%k] = 1;

        for(int r=0; r<k; r++){
            curr[ (int)((1L*r*arr[i])%k) ] += next[r];
        }

        for(int r=0; r<k; r++) ans[r] += curr[r];

        return dp[i] = curr;
    }
    public long[] resultArray(int[] nums, int k) {
        arr = nums;
        n = arr.length;
        this.k = k;

        dp = new long[n][];
        // for(int i=0; i<n; i++) Arrays.fill(dp[i],-1);

        ans = new long[k];

        sol(0);

        return ans;
    }
}
class Solution {
    int []pre;
    int n;
    int []dp ;
    int []a;

    int sol(int []a, int i){
        if(i==n-1) return pre[i+1];

        if(dp[i]!=Integer.MIN_VALUE) 
            return dp[i];

        int max = sol(a,i+1);
        if(i+1<n)
            max = Math.max(max,pre[i+1]-sol(a,i+1));

        return dp[i] = max;
    }

    int sol1(){

        int[] f = new int[n];
        f[n - 1] = pre[n];
        for (int i = n - 2; i >= 1; i--) {
            f[i] = Math.max(f[i + 1], pre[i+1] - f[i + 1]);
        }
        return f[1];
    }

    public int stoneGameVIII(int[] stones) {
        a = stones;
        n = stones.length;
        pre = new int[n+1];
        for(int i=0; i<n; i++) pre[i+1] = pre[i]+stones[i];

        // dp = new int[n];
        // Arrays.fill(dp,Integer.MIN_VALUE);
        // return sol(stones,1);

        return sol1();
    }
}
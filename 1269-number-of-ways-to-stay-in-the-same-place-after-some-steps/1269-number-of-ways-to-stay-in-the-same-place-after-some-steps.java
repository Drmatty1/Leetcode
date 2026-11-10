class Solution {
    int n ;
    int M = 1000000007;
    int [][]dp;
    int sol(int s, int i){

        if(i<0 || i>=n) return 0;
        if(s==0) return (i==0)?1:0;
        if(dp[s][i] != -1) return dp[s][i];

        int ans = sol(s-1,i) ;
        ans = (ans+sol(s-1,i-1))%M;
        ans = (ans+sol(s-1,i+1))%M;

        return dp[s][i]=ans;
    }

    // int sol1(int steps){

    //     if(i<0 || i>=n) return 0;
    //     if(s==0) return (i==0)?1:0;
    
    //     int [][]dp;

    //     for(int s=1; s<=steps; s++){
    //         for(int i=0; i<n && i<=steps; ++i){
    //             int ans = dp[s-1][i] ;
    //             if(i>0) ans = (ans+dp[s-1][i-1])%M;
    //             if(i<n-1) ans = (ans+dp[s-1][i+1])%M;
    //         }
    //     }

    //     return dp[steps][0];
    // }

    public int numWays(int steps, int arrLen) {
        n = arrLen;

        dp = new int[steps+1][steps+1];
        for(int i=0; i<=steps; ++i) Arrays.fill(dp[i],-1);
        return sol(steps,0);

        // return sol1(steps);
    }

}
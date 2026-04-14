class Solution {
    int M = Integer.MAX_VALUE;
    int sol( int clip, int disp, int t ){

        if(disp == t) return 0;
        if( disp > t ) return M;

        //op1
        int a = M;
        if( clip != 0 ) a = sol(clip, disp+clip,t);
        if( a != M ) a+=1;

        //op2
        int b = sol( disp, disp*2, t );
        if( b != M ) b+=2;

        return Math.min(a,b);

    }

     int sol1( int clip, int disp, int t, int [][]dp ){

        if(disp == t) return 0;
        if( disp > t ) return M;

        if( dp[clip][disp] != -1 ) return dp[clip][disp];

        //op1
        int a = M;
        if( clip != 0 ) a = sol1(clip, disp+clip,t, dp);
        if( a != M ) a+=1;

        //op2
        int b = sol1( disp, disp*2, t, dp );
        if( b != M ) b+=2;

        return dp[clip][disp] = Math.min(a,b);

    }

    public int minSteps(int n) {
        // return sol(0,1,n);

        int [][]dp = new int[n+1][n+1];
        for( int i=0; i<=n; i++ ) Arrays.fill(dp[i],-1);
        return sol1(0,1,n,dp);
    }
}
// learn bootom up + original approach
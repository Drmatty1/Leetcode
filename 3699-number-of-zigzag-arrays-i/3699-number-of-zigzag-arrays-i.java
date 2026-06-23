class Solution {
    int mod = 1000000007;
    long sol(int n, int idx, boolean less, int len, long [][][]dp, boolean [][][]vis){
        if( n == 0 ) return 1;

        if( vis[n][idx+1][less?1:0] ) return dp[n][idx+1][less?1:0];

        if(less){
            long ans = 0;
            int ub = (idx==-1?len:idx);
            for(int i=0; i<ub; i++){
                ans += sol(n-1,i,!less, len, dp, vis)%mod;
            }
            vis[n][idx+1][less?1:0] = true;
            dp[n][idx+1][less?1:0] = ans;
            return ans;

        }
        else{
            long ans = 0;
            int lb = (idx==-1?(-1):idx);
            for(int i=lb+1; i<len; i++){
                ans += sol(n-1,i,!less,len,dp,vis)%mod;
            }
            vis[n][idx+1][less?1:0] = true;
            dp[n][idx+1][less?1:0] = ans;
            return ans;
        }

    }

    long sol1(int N, int len ){

        long [][]dp1 = new long[len+1][2];

        for(int idx=0; idx<=len; idx++){
            dp1[idx][0] = 1;
            dp1[idx][1] = 1;
        }

        long[][] dp2 = new long[len+1][2];
        long []pre0 = new long[len+2];
        long []pre1 = new long[len+2];

        for(int n = 1; n <= N; n++ ){

            // long[][] dp2 = new long[len+1][2];

            // long []pre0 = new long[len+2];
            // long []pre1 = new long[len+2];
            pre0[0] = 0;
            pre1[0] = 0;
            for(int i=0; i<=len; i++){
                pre0[i+1] = (pre0[i] + dp1[i][0]) % mod;
            }
            for(int i=0; i<=len; i++){
               pre1[i+1] = (pre1[i] + dp1[i][1]) % mod;
            }

            for(int idx = -1; idx<len; idx++){


                for(int less = 0; less<2; less++){
                    
                    if(less==1){
                        long ans = 0;
                        int ub = (idx==-1?len:idx);
                        // for(int i=0; i<ub; i++){
                        //     ans += dp1[i+1][1-less]%mod;
                        // }
                        ans = (pre0[ub+1]-pre0[1]+mod)%mod;
                        dp2[idx+1][less] = ans;

                    }
                    else{
                        long ans = 0;
                        int lb = (idx==-1?(-1):idx);
                        // for(int i=lb+1; i<len; i++){
                        //     ans += dp1[i+1][1-less]%mod;
                        // }
                        ans = (pre1[len+1]-pre1[lb+1+1]+mod)%mod;
                        dp2[idx+1][less] = ans;
    
                    }
                }
            }
            long[][] temp = dp1;
            dp1 = dp2;
            dp2 = temp;
        }
        return (dp1[0][0] + dp1[0][1]) % mod;
    }


    public int zigZagArrays(int n, int l, int r) {
        
        int len = r-l+1;
        // long [][][]dp = new long[n+1][r-l+2][2];

        // boolean [][][]vis = new boolean[n+1][r-l+2][2];
        // long a = sol(n, -1, true, len, dp, vis);

        // vis = new boolean[n+1][r-l+2][2];
        // long b = sol(n, -1, false,len, dp, vis);

        // return (int)((a+b)%mod);

        return (int)sol1(n, len);
    }
}
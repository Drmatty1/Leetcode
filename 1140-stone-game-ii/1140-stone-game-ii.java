class Solution {
    int solve( int[] p, int i, int m, int []suff ){
        int l = p.length;
        if( i >= l ) return 0;
        int sum = 0;
        int ans = 0;
        for( int t=i; t<i+2*m && t<l; t++ ){
            sum += p[t];
            int a = solve( p, t+1, Math.max(m,t-i+1), suff );  
            ans = Math.max(ans,sum+suff[t+1]-a);
        }
        return ans;
    }

    int solve1( int[] p, int i, int m, int []suff, int[][]dp ){
        int l = p.length;
        if( i >= l ) return 0;

        if( dp[i][m] != 0 ) return dp[i][m];

        int sum = 0;
        int ans = 0;

        for( int t=i; t<i+2*m && t<l; t++ ){
            sum += p[t];
            int a = solve1( p, t+1, Math.max(m,t-i+1), suff,dp );  
            ans = Math.max(ans,sum+suff[t+1]-a);
        }
        return dp[i][m] = ans;
    }

    int sol2(int []p, int []suff){

        int l = p.length;
        int [][]dp = new int[l+1][l+1];

        for(int i=l-1; i>=0; i--){

            for(int m=l; m>=1; m--){
                
                int sum = 0;
                int ans = 0;
                for( int t=i; t<i+2*m && t<l; t++ ){
                    sum += p[t];
                    int a = dp[t+1][Math.max(m,t-i+1)] ;
                    ans = Math.max(ans,sum+suff[t+1]-a);
                }
                dp[i][m] = ans;

            }

        }
        return dp[0][1];
    }

    public int stoneGameII(int[] piles) {
        int l = piles.length;

        int []suff = new int[l+1];
        for( int i=l-1; i>=0; i-- ){
            suff[i] = suff[i+1]+piles[i];
        }

        // int [][] dp = new int[l][64];
        // return solve1(piles, 0, 1, suff, dp);

        return sol2(piles, suff);
    }
}
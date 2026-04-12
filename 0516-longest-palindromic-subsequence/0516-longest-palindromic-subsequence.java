class Solution {
    
    int sol(String s, int i, int j){
        if( i == j ) return 1;
        if( i > j ) return 0;

        int c1 = s.charAt(i), c2 = s.charAt(j);
        int ans =0;
        if( c1 == c2 ){
            ans = 2+sol(s, i+1, j-1);
        }
        else{
            int a = sol(s, i+1,j);
            int b = sol(s, i,j-1);
            ans = Math.max(a,b);
        }
        return ans;

    }

    int sol1(String s, int i, int j, int[][]dp){
        if( i == j ) return 1;
        if( i > j ) return 0;

        if( dp[i][j] != -1 ) return dp[i][j];

        int c1 = s.charAt(i), c2 = s.charAt(j);
        int ans =0;
        if( c1 == c2 ){
            ans = 2+sol1(s, i+1, j-1,dp);
        }
        else{
            int a = sol1(s, i+1,j,dp);
            int b = sol1(s, i,j-1,dp);
            ans = Math.max(a,b);
        }
        return dp[i][j] = ans;

    }

    public int longestPalindromeSubseq(String s) {
        // return sol(s,0,s.length()-1);

        int l = s.length();
        int [][]dp = new int[l][l];
        for( int i=0; i<l; i++ )Arrays.fill(dp[i],-1);
        return sol1(s,0,s.length()-1,dp);

    }
}
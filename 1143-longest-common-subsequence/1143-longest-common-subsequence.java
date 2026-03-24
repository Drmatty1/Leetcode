class Solution {
    int sol( String a, String b, int i, int j ){
        if( i == a.length() || j == b.length() ){
            return 0;
        }
        char p = a.charAt(i), q = b.charAt(j);
        if( p == q ){
            //pick
            int op1 = 1 + sol(a,b,i+1,j+1);
            
            //skip
            int op2 = sol(a,b,i+1,j);

            return Math.max(op1,op2);
        }
        int op1 = sol(a,b,i+1,j);
        int op2 = sol(a,b,i,j+1);
        return Math.max(op1,op2);

    }
    int sol1( String a, String b, int i, int j, int[][]dp ){
        if( i == a.length() || j == b.length() ){
            return 0;
        }

        if( dp[i][j] != -1 ) return dp[i][j];

        char p = a.charAt(i), q = b.charAt(j);
        if( p == q ){
            //pick
            int op1 = 1 + sol1(a,b,i+1,j+1, dp);
            
            //skip
            int op2 = sol1(a,b,i+1,j, dp);

            return dp[i][j] = Math.max(op1,op2);
        }
        int op1 = sol1(a,b,i+1,j,dp);
        int op2 = sol1(a,b,i,j+1,dp);
        return dp[i][j] = Math.max(op1,op2);

    }
    public int longestCommonSubsequence(String text1, String text2) {
        
        int [][]dp =  new int[1001][1001];
        for( int i=0; i<1001; i++ ){
            for( int j=0; j<1001; j++ ){
                dp[i][j] = -1;
            }
        }
        // int op1 = sol(text1, text2, 0, 0);
        int op1 = sol1(text1, text2, 0, 0, dp);
        return op1;
    }
}
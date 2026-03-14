class Solution {
    
    static String [][]dp = new String [10][];
    static {
        for( int i=0; i<10; i++ ){
            dp[i] = new String[3*(int)Math.pow(2,i)];
        }
    }
    static char []chars = { 'a', 'b', 'c' };

    void solve( int l, int[] a, int n, char[]temp, char p ){
        
        if( l == n ){
            dp[n-1][a[0]++] = new String(temp);
            return ;
        }

        for( char c : chars ){
           
            if( p == '1' || c != p ) {
                temp[l] = c ;
                solve( l+1, a, n, temp, c );
            }
        }
    }
    void generate( int n ){
        int []a = {0};
        char []arr = new char[n];

        solve( 0, a, n, arr , '1' );
    }

    public String getHappyString(int n, int k) {
        
        int t = 3*(int)(Math.pow(2,n-1));
        if( k > t ) return "";
        
        if( dp[n-1][k-1] != null ) return  dp[n-1][k-1];

        generate( n );

        return dp[n-1][k-1];
    }
}
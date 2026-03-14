class Solution {
    
    static String [][]dp = new String [10][];
    static {
        for( int i=0; i<10; i++ ){
            dp[i] = new String[3*(int)Math.pow(2,i)];
        }
    }

    char []chars = { 'a', 'b', 'c' };
    void solve( int l, int[] a, int n, char[]temp, char p ){
        
        if( l == n ){
            dp[n-1][a[0]++] = new String(temp);
            System.out.println("ppi"+" "+l+" "+n);
            return ;
        }

        for( char c : chars ){
            System.out.println(c+" "+p+" "+l);
           
            if( p == '1' || c != p ) {
                System.out.println("ii"+" "+c+" "+p);
                temp[l] = c ;
                // if( l != 0 ) System.out.println(temp[l-1]+" "+temp[l]);
                solve( l+1, a, n, temp, c );
            }
        }
    }
    void generate( int n ){
        int []a = {0};
        char []arr = new char[n];

        // System.out.println(t+"hi");
        solve( 0, a, n, arr , '1' );
    }

    public String getHappyString(int n, int k) {
        
        int t = 3*(int)(Math.pow(2,n-1));
        if( k > t ) return "";
        
        if( dp[n-1][k-1] != null ) return  dp[n-1][k-1];

        generate( n );

        for( String s : dp[2] ){
            System.out.println(s);
        }

        return dp[n-1][k-1];
    }
}
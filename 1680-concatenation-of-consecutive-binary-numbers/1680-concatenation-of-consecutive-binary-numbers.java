class Solution {
    static int[]dp = new int[100001];
    public int concatenatedBinary(int n) {
        int M = (int)1e9+7;
        if( dp[n] != 0 ) return dp[n];
        int ans = 0;
        for( int i=1; i<=n; i++ ){
            int temp = i;
            int test = (int)Math.pow(2,17);
            while( (test&temp) == 0 ) test = test>>1;
            while( test != 0) {
                ans = ( (ans<<1)+((temp&test)!=0?1:0) )%M ;
                test = test>>1; 
            }
        }
        dp[n] = ans;
        return (ans);
    }
}
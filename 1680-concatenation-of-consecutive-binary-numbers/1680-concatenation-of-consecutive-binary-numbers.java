class Solution {
    static int[]dp = new int[100001];
    static int max = 0;
    
    int solve1( int n ){
        int M = (int)1e9+7;
        int ans = 0;
        if( n <= max ) return dp[n];
        
        ans = dp[max];

        for( int i=max+1; i<=n; i++ ){
            int temp = i;
            int test = 1<<17;
            while( (test&temp) == 0 ) test = test>>1;
            while( test != 0) {
                ans = ( (ans<<1)|((temp&test)!=0?1:0) )%M ;
                test = test>>1; 
            }
            max = Math.max(max,i);
            dp[i] = ans;
        }
        return (ans);
    }
    public int concatenatedBinary(int n) {
        return solve1(n);
    }
}
//
/**
class Solution {
    public int concatenatedBinary(int n) {
        int bi = 0;
        long res = 0;
        final long MOD = (long)(1e9 + 7);
        for(int i=1;i<=n;i++){
            if((i&(i-1)) == 0) bi++;
            res = ((res << bi)+i)%MOD;
        }
        OR
        for(int i=1; i<=n; i++) {
            int digits = 32 - Integer.numberOfLeadingZeros(i);
            res = ((((res << digits)%mod)+i)%mod);
        }
        return (int)res;
    }
}
 */
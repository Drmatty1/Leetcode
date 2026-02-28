class Solution {
 
    public int concatenatedBinary(int n) {
        int M = (int)1e9+7;
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
        return (ans);
    }
}
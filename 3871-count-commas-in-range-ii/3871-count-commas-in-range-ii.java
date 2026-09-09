class Solution {
    public long countCommas(long n) {
        long ans = 0;
        long res = 999_999_999_999_999L;
        int comma = 5;
        while( res >= 999 ){
            if( n >= res ){
                ans += comma*(n-res);
                n-= (n-res);
            }
            comma --;
            res = res/1000;
        }
        return ans;
    }
}

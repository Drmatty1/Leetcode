class Solution {
    long[] count(int []v, int[]dec , long m){
        int s =  v.length;
        long sum = 0, ct = 0;
        for(int i=0; i<s; i++){
            long a = v[i];
            if( m > a ) continue ; // n = 0
            long d = -dec[i];
            long n = (m-a)/d+1;
            sum += n * (2 * a + (n - 1) * d) / 2;
            ct += n;
        }
        return new long[]{ct, sum};
    }
    public int maxTotalValue(int[] value, int[] decay, int m) {
        int mod = 1000000007;
        int n =  value.length;
        long l = 1, u = (long)(1e9);
        long []ps = {0,0};
        long psMid= -1;
        
        while( l <= u){
            long mid = (u-l)/2+l;
            long []res = count(value,decay,mid);
            
            if(res[0] >= m ){
                ps = res;
                psMid = mid;
                l = mid+1;
            }
            else {
                u = mid-1;
            }
        }

        if(psMid == -1){
            return (int)((count(value,decay,0)[1])%mod);
        }
        long ans = (ps[1] - psMid*(ps[0]-m))%mod;
        return (int)ans;
    }
}
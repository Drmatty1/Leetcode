class Solution {
    long[] lc ;
    int[] sign ;

    long gcd(long a, long b){
        if(a==0) return b;
        return gcd(b%a,a);
    }
    long lcm(long a, long b){
        long lcm = a/gcd(a,b)*b;
        return lcm;
    }
    long count(int []a, long m){
        int n = a.length;
        long count=0;
        for(int mask=1; mask < (1<<n) ; mask++){

            long lcm = lc[mask];
            boolean flag = sign[mask]>0 ;

            if(flag) count += m/lcm;
            else count -= m/lcm;
        }
        return count;
    }

    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        int total = 1 << n;

        lc = new long[total];
        sign = new int[total];

        lc[0] = 1;

        for (int mask = 1; mask < total; mask++) {

            int bit = Integer.numberOfTrailingZeros(mask);
            int prev = mask & (mask - 1);

            lc[mask] = lcm(lc[prev], coins[bit]);

            int bits = Integer.bitCount(mask);

            sign[mask] = (bits % 2 == 1) ? 1 : -1;
        }

        long l = 0;
        long u = (long) k * Arrays.stream(coins).min().getAsInt();
    
        while(l<=u){
            long mid = (u+l)/2;
            if(count(coins,mid)>=k){
                u = mid-1;
            }
            else 
                l = mid+1;
                
        }
        return l;
    }
}
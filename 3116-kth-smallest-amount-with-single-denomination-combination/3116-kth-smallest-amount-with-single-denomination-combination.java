class Solution {
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

            long lcm = 1;
            boolean flag=true;

            for(int i=0; i<n; i++){
                if( ((mask>>i)&1) == 1 ){
                    lcm = lcm(lcm,a[i]);
                    flag = !flag;
                }
            }

            if(flag) count -= m/lcm;
            else count += m/lcm;
        }
        return count;
    }

    public long findKthSmallest(int[] coins, int k) {
        long l = 1, u = 5_000_000_0000L;
    
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
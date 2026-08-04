class Solution {
    int mod = 1337;
    long power10(int a, int zero){
        if(zero == 0) return a;
        if(zero==1) return power(a,10);
        if(zero==2) return power(a,100);
        if(zero==3) return power(a,1000);
        if(zero==4) return power(a,10000);
        
        // a^10
        long res = power10(a,zero-4);
        return power(res,10000);

    }
    long power(long a, int b){
        if(b==0) return 1;

        long res = power(a,b/2);
        res = (res*res)%mod;

        if(b%2 != 0) res = (res*a)%mod;

        return res;
    }
    public int superPow(int a, int[] b) {
        if(a==1) return 1;

        int n = b.length;
        long ans= 1;

        for(int i=0; i<n; i++){

            int rem = n-i-1;
            long res = power10(a,rem);

            res = power(res,b[i]);

            ans = (ans*res)%mod;

        }
        return (int)ans;
    }
}
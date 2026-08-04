class Solution {
    int mod = 1337;
    Map<String,Integer> dp ;

    int power10(int a, int zero){
        if(zero == 0) return a%mod;
        if(zero==1) return power(a,10);

        String key = a+"-"+zero;
        if(dp.containsKey(key) ) return dp.get(key);
        
        // a^10
        long res = power10(a,zero-1);


        int ans = power(res,10);

        dp.put(key,ans);
        return ans;
    }

    int power(long a, int b){
        if(b==0) return 1;

        long res = power(a,b/2);
        res = (res*res)%mod;

        if(b%2 != 0) res = (res*a)%mod;

        return (int)res;
    }
    public int superPow(int a, int[] b) {
        if(a==1) return 1;

        int n = b.length;
        long ans= 1;

        dp = new HashMap<>();
        
        for(int i=0; i<n; i++){

            int rem = n-i-1;
            long res = power10(a,rem);

            res = power(res,b[i]);

            ans = (ans*res)%mod;

        }
        return (int)ans;
    }
}
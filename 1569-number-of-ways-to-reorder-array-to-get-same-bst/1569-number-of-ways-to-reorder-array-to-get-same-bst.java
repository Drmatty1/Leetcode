class Solution {
    long MOD = 1_000_000_007L;
    long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
    long modInverse(long n) {
        return power(n, MOD - 2);
    }
    long nCr(long n, long r) {
        if (r < 0 || r > n) return 0;
        if (r == 0 || r == n) return 1;

        // Symmetry: C(n, r) == C(n, n - r)
        r = Math.min(r, n - r);

        long num = 1;
        long den = 1;

        for (long i = 1; i <= r; i++) {
            num = (num * ((n - i + 1) % MOD)) % MOD;
            den = (den * i) % MOD;
        }

        return (num * modInverse(den)) % MOD;
    }

    int sol(int[] nums) {
        int m = nums.length-1;
        if(m==1 || m == 0) return 1;
        int r = 0;
        for(int i=1; i<=m; i++) if(nums[i] < nums[0]) r++;
        if(r==0 || r==m){
            int []arr = new int[m];
            for(int i=1; i<=m; i++)
                arr[i-1] = nums[i];
            return sol(arr);
        }
        
        int []a = new int[r];
        int []b = new int[m-r];
        int x=0,y=0;
        for(int i=1; i<=m; i++){
            if(nums[i]<nums[0]) a[x++] = nums[i];
            else b[y++] = nums[i];
        }
        long a1 = sol(a), b1 = sol(b);
        long c = nCr(m,r);
        return (int)(( (a1*b1)%MOD * c ) %MOD);
    }

    public int numOfWays(int[] nums) {
        return sol(nums)-1;
    }
}
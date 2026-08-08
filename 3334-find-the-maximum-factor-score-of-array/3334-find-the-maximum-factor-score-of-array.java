class Solution {

    int gcd(long a, long b){
        if(a==0) return (int)b;
        return gcd(b%a,a);
    }
    long lcm(long a, long b){
        return (a*b)/gcd(a,b);
    }

    public long maxScore(int[] nums) {
        int n = nums.length;

        int []pref = new int[n];
        long []lcm = new long[n];
        lcm[0] = nums[0];
        pref[0] = nums[0];
        for(int i=1; i<n; i++){
            lcm[i] = lcm(nums[i],lcm[i-1]);
            pref[i] = gcd(pref[i-1],nums[i]);
        }

        int []suff = new int[n];
        long []lcm2 = new long[n];
        lcm2[n-1] = nums[n-1];
        suff[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            lcm2[i] = lcm(nums[i],lcm2[i+1]);
            suff[i] = gcd(suff[i+1],nums[i]);
        }

        long max = 0;
        max = 1L*pref[n-1]*lcm[n-1];

        if(n==1) return max;
        
        // cases where first and last are removed
        long temp = Math.max(1L*pref[n-2]*lcm[n-2], 1L*suff[1]*lcm2[1]);
        max = Math.max(max,temp);

        for(int i=1; i<n-1; i++){
            int gcd0 = gcd(pref[i-1],suff[i+1]);
            long lcm0 = lcm(lcm[i-1],lcm2[i+1]);

            max = Math.max(max, gcd0*lcm0);
        }

        return max;

    }
}
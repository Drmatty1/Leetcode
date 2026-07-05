class Solution {
    List<Integer> p ;
    long gcd(long a, long b){
        if(a==0) return b;
        return gcd(b%a, a);
    }
    void makePrime( int max ){
        int l = max;
        boolean []sieve = new boolean[l+1];
        Arrays.fill(sieve, true);
        sieve[1] = false;
        for(int i=2; i*i<l; i++){
            if(sieve[i] == false) continue;
            for(int m=i*i; m<l; m+=i){
                sieve[m] = false;
            }
        }

        p = new ArrayList<>();
        for(int i=2; i<l; i++) 
            if(sieve[i]) p.add(i);

    }
    public int divisibleGame(int[] nums) {
        int n =  nums.length;
        int mod = 1000000007;
        long maxDif = -mod;
        long bestK = 0;

        int maxVal = 2; // k must be at least 2
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        makePrime(maxVal+2);


        for(int k : p){           
        
            long currentMax = Long.MIN_VALUE;
            long runningSum = 0;
            
            for (int i = 0; i < n; i++) {
                long val = (nums[i] % k == 0) ? nums[i] : -nums[i];
                
                runningSum += val;
                if (runningSum > currentMax) {
                    currentMax = runningSum;
                }
                if (runningSum < 0) {
                    runningSum = 0;
                }
            }

            if (currentMax > maxDif) {
                maxDif = currentMax;
                bestK = k;
            }

        }
        int res = (int)((maxDif*bestK)%mod);
        if(res < 0) res+=mod;
        return res;
    }
}
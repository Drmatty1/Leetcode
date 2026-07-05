class Solution {
    int gcd(int a, int b){
        if(a==0) return b;
        return gcd(b%a,a);
    }
    long hash(int a, int b){
        int hcf = gcd(a,b);
        a = a/hcf;
        b = b/hcf;
        return ( ((long)a)<<32 | b );
    }
    public long numberOfSubsequences(int[] nums) {
        Map<Long,Integer> map = new HashMap<>();
        long ans = 0;
        int n = nums.length;
        for(int r=4; r<n-2; r++){

            // new q is avilable (i.e. r-2)
            int q = r-2;
            for(int p=0; p<=q-2; p++){
                long key = hash(nums[p],nums[q]);
                map.put(key,map.getOrDefault(key,0)+1);
            }

            for(int s = r+2; s<n; s++){
                long currKey = hash(nums[s],nums[r]);
                ans += map.getOrDefault(currKey,0);
            }
        }
        return ans;
    }
}
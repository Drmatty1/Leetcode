class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum =0, n = nums.length;
    
        int []s = new int[n];
        s[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            s[i] += nums[i]+s[i+1];
        }

        int G0 = 0;
        for(int i=0; i<n; i++) G0 += i*nums[i];
        
        int res = G0;
        sum = s[0];

        for(int i=1; i<n; i++){
            int F0 = G0+sum-n*s[n-i];
            res = Math.max(F0,res);
            G0 = G0 + sum;
        }
        return res;
    }
}
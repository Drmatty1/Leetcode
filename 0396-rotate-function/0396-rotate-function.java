class Solution {
    public int maxRotateFunction(int[] nums) {
        
        int n = nums.length;
        int G0 = 0, sum =0;

        for(int i=n-1; i>=0; i--){
            G0 += i*nums[i];
            sum += nums[i];
        }
  
        int res = G0;
        int suf = 0;

        for(int i=1; i<n; i++){
            suf += nums[n-i];
            int F0 = G0+sum-n*suf;
            res = Math.max(F0,res);
            G0 = G0 + sum;
        }
        return res;
    }
}
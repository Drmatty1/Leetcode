class Solution {
    Integer[] dp;
    int sol(int i, int []nums){

        if(i>=nums.length) return 0;

        if(dp[i] != null) return dp[i];

        int max = 0;

        //pick
        max = nums[i] + sol(i+2,nums);

        //skip
        max = Math.max(max, sol(i+1,nums));

        return dp[i] = max;

    }
    public int rob(int[] nums) {
        dp = new Integer[nums.length];
        return sol(0,nums);
    }
}
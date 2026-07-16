class Solution {
    Map<Long, Integer> dp = new HashMap<>();
    int sol(int i, int carry, int[] nums){

        if(i>=nums.length) return carry;
        if( i == nums.length-1) return Math.max(nums[i],carry);

        long key = (((long) i) << 32) | (carry & 0xffffffffL);
        if(dp.containsKey(key)) return dp.get(key);

        //c1
        int a = Math.max(carry,nums[i]) + sol(i+2,nums[i+1],nums);

        //c2
        int b = Math.max(carry,nums[i+1]) + sol(i+2,nums[i],nums);

        //c3
        int c = Math.max(nums[i], nums[i+1]) + sol(i+2,carry,nums);


        int ans = Math.min(a,Math.min(b,c));
        dp.put(key, ans);
        return ans;

    }

    public int minCost(int[] nums) {
        dp = new HashMap<>();
        return sol(1,nums[0],nums);
    }
}
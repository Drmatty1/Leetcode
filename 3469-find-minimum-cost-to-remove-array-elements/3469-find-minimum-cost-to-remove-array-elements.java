class Solution {
    Map<Long, Integer> dp = new HashMap<>();
    Integer[][]dp1 ;
    int sol(int i, int carry, int[] nums){

        if(i>=nums.length) return carry;
        if( i == nums.length-1) return Math.max(nums[i],carry);

        long key = (((long) i) << 32) | (carry);
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

    int sol1(int i, int j, int[] nums){

        if(i>=nums.length) return nums[j];
        if( i == nums.length-1) return Math.max(nums[i],nums[j]);

        // long key = (((long) i) << 32) | (j);
        if(dp1[i][j] != null ) return dp1[i][j];

        //c1
        int a = Math.max(nums[j],nums[i]) + sol1(i+2,i+1,nums);

        //c2
        int b = Math.max(nums[j],nums[i+1]) + sol1(i+2,i,nums);

        //c3
        int c = Math.max(nums[i], nums[i+1]) + sol1(i+2,j,nums);


        int ans = Math.min(a,Math.min(b,c));
        
        return dp1[i][j] = ans;

    }


    public int minCost(int[] nums) {
        // dp = new HashMap<>();
        // return sol(1,nums[0],nums);

        int n = nums.length;
        dp1 = new Integer[n+2][n];
        return sol1(1,0,nums);
    }
}
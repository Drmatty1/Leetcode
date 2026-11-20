class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for(int e: nums) max = Math.max(max,e);

        int []dp = new int[max+2];
        for(int e: nums){
            dp[e+1] = dp[e]+1;
            dp[e] = dp[e-1]+1;
        }

        max = 1;
        for(int e: dp) max = Math.max(max,e);
        return max;
    }
}
// 1 1 1 2 5
class Solution {
    public int maximumJumps(int[] nums, int target) {
        
        int n = nums.length;
        int []dp = new int[n];
        for(int i=0; i<n; i++) dp[i] = -1;
        dp[0] = 0;

        for( int i=0; i<n-1; i++ ){

            //Relaxing j for i, 1->2,3 : 2->3  , dp[3] = 2;
            for(int j=i+1; j<n; j++){
                if( Math.abs(nums[j]-nums[i]) <= target ){
                    if(dp[i] != -1)
                        dp[j] = Math.max(dp[j], dp[i]+1);
                }      
            }
        }

        return dp[n-1];
    }
}
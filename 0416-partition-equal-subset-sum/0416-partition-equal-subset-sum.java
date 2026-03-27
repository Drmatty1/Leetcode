class Solution {
    boolean solve( int[] nums, int i, int target ){
        if( target == 0 ) return true;
        if( i == nums.length ) return false;
        
        boolean op1 = false;
        if( nums[i] <= target ){
            op1 = solve( nums, i+1, target-nums[i] );
        }

        boolean op2 = solve( nums, i+1, target );

        return op1 || op2 ;
        
    }

    boolean solve1( int[] nums, int i, int target, int[][]dp ){
        if( target == 0 ) return true;
        if( i == nums.length ) return false;
        
        if( dp[i][target] != 0 ) return dp[i][target]==1;

        boolean op1 = false;
        if( nums[i] <= target ){
            op1 = solve1( nums, i+1, target-nums[i], dp );
        }

        boolean op2 = solve1( nums, i+1, target, dp );


        boolean res = op1||op2;
        dp[i][target] = res?1:2;
        return res ;
        
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for( int e : nums ) sum+=e;
        if( sum%2 != 0 ) return false;
        // return solve( nums, 0, sum/2 );

        int[][]dp = new int[nums.length+1][20001];
        return solve1( nums, 0, sum/2, dp );
    }
}
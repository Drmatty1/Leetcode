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

    boolean solve21( int[] nums, int target ){

        int l = nums.length;
        
        boolean [][]dp = new boolean[l+1][target+1];
        
        for( int i=0; i<l+1; i++ ){
            dp[i][0] = true;
        }

        for( int i=l-1; i>=0; i-- ){
            for( int t = 1; t<=target; t++ ){

                boolean op1 = false;
                if( nums[i] <= t ){
                    op1 = dp[i+1][t-nums[i]];
                }

                boolean op2 = dp[i+1][t];

                dp[i][t] = op1||op2;
            }
        }

        return dp[0][target];
    }

    boolean solve22( int[] nums, int target ){

        int l = nums.length;
        
        boolean [][]dp = new boolean[l+1][target+1];
        
        for( int i=0; i<l+1; i++ ){
            dp[i][0] = true;
        }
        
        // if (nums[0] <= target) {
        //     dp[0][nums[0]] = true;
        // }

        for( int i=0; i<l; i++ ){
            for( int t = 1; t<=target; t++ ){

                boolean op1 = false;
                if( nums[i] <= t ){
                    op1 = i==0?false:dp[i-1][t-nums[i]];
                }

                boolean op2 = i==0?false:dp[i-1][t];

                dp[i][t] = op1||op2;
            }
        }

        return dp[l-1][target];
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for( int e : nums ) sum+=e;
        if( sum%2 != 0 ) return false;
        // return solve( nums, 0, sum/2 );

        // int[][]dp = new int[nums.length+1][20001];
        // return solve1( nums, 0, sum/2, dp );

        // return solve21(nums, sum/2);
        return solve22(nums, sum/2);
    }
}
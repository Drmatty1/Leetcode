class Solution {
    int mod = 1000000007;
    Integer [][][]dp ;
    
    int gcd( int a, int b ){
        if(a==0) return b;
        return gcd(b%a,a);
    }

    int sol(int i, int g1, int g2, int[]nums){
        if(i==nums.length) return (g1>0 && g2==g1)?1:0;

        int ans = sol(i+1,g1,g2,nums);

        //add elem i, in seq1
        ans = (ans+sol(i+1,gcd(g1,nums[i]),g2,nums))%mod;

        // add to seq2
        ans = (ans+sol(i+1,g1,gcd(g2,nums[i]),nums))%mod;

        return ans;
    }

    int sol1(int i, int g1, int g2, int[]nums){
        if(i==nums.length) return (g1>0 && g2==g1)?1:0;

        if(dp[i][g1][g2] != null) return dp[i][g1][g2];

        int ans = sol1(i+1,g1,g2,nums);

        //add elem i, in seq1
        ans = (ans+sol1(i+1,gcd(g1,nums[i]),g2,nums))%mod;

        // add to seq2
        ans = (ans+sol1(i+1,g1,gcd(g2,nums[i]),nums))%mod;

        return dp[i][g1][g2] = ans;
    }

    int sol2(int[]nums){

        // if(i==nums.length) return (g1>0 && g2==g1)?1:0;
        int maxGcd = 1;
        for(int e:nums) maxGcd = Math.max(maxGcd,e);
        maxGcd = maxGcd+1;

        int[][]gcd_dp = new int[maxGcd][maxGcd];
        for(int i=0; i<maxGcd; i++ ) 
            for(int j=0;j<maxGcd;j++)
                gcd_dp[i][j]=gcd(i,j);
        
        int n = nums.length;
        int [][][]dp = new int[n+1][maxGcd][maxGcd];
       
        for(int j=1; j<maxGcd; j++){
            dp[n][j][j] = 1;
        }
        

        for(int i=n-1; i>=0; i-- ){
            
            for(int g1 = maxGcd-1; g1>=0; g1--){
                int ng1 = gcd_dp[g1][nums[i]];

                for(int g2 = maxGcd-1; g2>=0; g2--){
                    int ng2 = gcd_dp[g2][nums[i]];

                    int ans = dp[i+1][g1][g2];

                    //add elem i, in seq1
                    ans = (ans+dp[i+1][ng1][g2])%mod;

                    // add to seq2
                    ans = (ans+dp[i+1][g1][ng2])%mod;

                    dp[i][g1][g2] = ans;

                }

            }

        }

        return dp[0][0][0];
    }

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;

        // dp = new Integer[n][201][201];
        // return sol(0,0,0,nums);
        // return sol1(0,0,0,nums);
        
        return sol2(nums);
    }
}
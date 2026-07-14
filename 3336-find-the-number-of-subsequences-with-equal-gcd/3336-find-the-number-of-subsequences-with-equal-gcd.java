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

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        dp = new Integer[n][201][201];
        
        // return sol(0,0,0,nums);
        return sol1(0,0,0,nums);
    }
}
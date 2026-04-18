class Solution {
    int sol(int []arr, int curr, int i, int t){
        
        if(i>=arr.length){
            if( curr == t )return 1;
            return 0;
        }
        int a = sol(arr,curr-arr[i],i+1,t);
        int b = sol(arr,curr+arr[i],i+1,t);
        return a+b;
    }

    int sol1(int []arr, int curr, int i, int t,int [][]dp){
        
        if(i>=arr.length){
            if( curr == t )return 1;
            return 0;
        }
        int m=1001;
        if(dp[i][curr+m]!=-1)return dp[i][curr+m];
        int a = sol1(arr,curr-arr[i],i+1,t,dp);
        int b = sol1(arr,curr+arr[i],i+1,t,dp);
        return dp[i][curr+m]=a+b;
    }
    public int findTargetSumWays(int[] nums, int target) {         
        // return sol(nums,0,0,target);

        int n = nums.length;
        int [][]dp = new int[n][1001+1001];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
        return sol1(nums,0,0,target,dp);
    }
}
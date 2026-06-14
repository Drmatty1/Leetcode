class Solution {
    int [][]dp ;
    int solve(int i,int prevArr,int[] nums1, int[] nums2)
    {
        if(i>=nums1.length) return 0;             
        
        if(dp[i][prevArr] != -1 ) return dp[i][prevArr];
        int ans=0;
        if(prevArr==0)
        {
            int nontake = solve( i +1, 0,nums1,nums2);    
            int take1=1+solve(i+1,1,nums1,nums2);    
            int take2=1+solve(i+1,2,nums1,nums2);    
            ans=Math.max(nontake,Math.max(take1,take2));            
           
        }
        else 
        {
            if(prevArr==1)                         // prev array is nums1
            {
                if(nums1[i]>=nums1[i-1]) ans=Math.max(ans,1+solve(i+1,1,nums1,nums2)); // we will update our ans if cur val is greater or equal previous value 
                if(nums2[i]>=nums1[i-1]) ans=Math.max(ans,1+solve(i+1,2,nums1,nums2));
                
            }
            else if(prevArr==2)                    // prev array is num2 
            {
                if(nums1[i] >=nums2[i-1]) ans=Math.max(ans,1+solve(i+1,1,nums1,nums2));               
                if(nums2[i]>=nums2[i-1]) ans=Math.max(ans,1+solve(i+1,2,nums1,nums2));               
            }          
        }

        return dp[i][prevArr] = ans;
    }
    int solOP(int[] nums1, int[] nums2) {
        int n = nums1.length;

        for(int i = n-1; i>=0; i--){

            if(nums1[i] > nums2[i]){
                int temp = nums1[i];
                nums1[i] = nums2[i];
                nums2[i] = temp;
            }
        }

        int []dp1 = new int[n];
        int []dp2 = new int[n];
        dp1[n-1] = 1;
        dp2[n-1] = 1;
        int ans = 1;
        for(int i=n-2; i>=0; i--){

            if(nums1[i] <= nums1[i+1]) dp1[i] = 1+dp1[i+1];
            else if( nums1[i] <= nums2[i+1] ) dp1[i] = 1+dp2[i+1];
            else dp1[i] = 1;

            if(nums2[i] <= nums1[i+1]) dp2[i] = 1+dp1[i+1];
            else if( nums2[i] <= nums2[i+1] ) dp2[i] = 1+dp2[i+1];
            else dp2[i] = 1;

            ans = Math.max(ans,Math.max(dp1[i],dp2[i]));

        }

       
        return ans;
    }
    int solOP1(int[] nums1, int[] nums2) {
        int n = nums1.length;

        for(int i = n-1; i>=0; i--){

            if(nums1[i] > nums2[i]){
                int temp = nums1[i];
                nums1[i] = nums2[i];
                nums2[i] = temp;
            }
        }

       
        int dp1_n = 1, dp2_n = 1;
        int dp1 , dp2;
        int ans = 1;
        for(int i=n-2; i>=0; i--){

            if(nums1[i] <= nums1[i+1]) dp1 = 1+dp1_n;
            else if( nums1[i] <= nums2[i+1] ) dp1 = 1+dp2_n;
            else dp1 = 1;

            if(nums2[i] <= nums1[i+1]) dp2 = 1+dp1_n;
            else if( nums2[i] <= nums2[i+1] ) dp2 = 1+dp2_n;
            else dp2 = 1;

            ans = Math.max(ans,Math.max(dp1,dp2));
            dp1_n = dp1;
            dp2_n = dp2;

        }
        return ans;
    }

    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        // return solOP1(nums1, nums2);

        int n = nums1.length;
        dp = new int[n][3];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(0,0,nums1,nums2);

    }
}
class Solution {
    boolean sol1(int []a, int i, int j, long diff){
        if(i==j) return (diff+a[i]>=0);
        if(i>j ) return diff>=0;

        boolean p=false, b=false, c=false, d=false;
        // System.out.println(i+" "+j+" "+diff);

        p = sol1(a,i+1,j-1,diff+a[i]-a[j]);
        if(i+1 < a.length)
            b = sol1(a,i+2,j,diff+a[i]-a[i+1]);
        c = sol1(a,i+1,j-1,diff+a[j]-a[i]);
        if(j-1 >= 0)
            d = sol1(a,i,j-2,diff+a[j]-a[j-1]);
        
        return p&&b || c&&d;
    }

    int sol2(int []arr, int i, int j){
        if(i==j) return arr[i];

        int a = arr[i] - sol2(arr,i+1,j);
        int b = arr[j] - sol2(arr,i,j-1);

        return Math.max(a,b);
    }
    int sol21(int []arr, int i, int j, int[][]dp){
        if(i==j) return arr[i];

        if(dp[i][j] != -1) return dp[i][j];

        int a = arr[i] - sol21(arr,i+1,j,dp);
        int b = arr[j] - sol21(arr,i,j-1,dp);

        return dp[i][j] = Math.max(a,b);
    }
    int sol22(int []arr){
        int n = arr.length;
        int [][]dp = new int[n+1][n+1];

        for(int i=0; i<n; i++) dp[i][i] = arr[i];
        /**
        dp[i][j] = Math.max(
                    arr[i]-dp[i+1][j],arr[j]-dp[i][j-1]
                );
         */
        for(int i=n-1; i>=0; i--){
            for(int j=i+1; j<n; j++){
                dp[i][j] = Math.max(
                    arr[i]-dp[i+1][j],arr[j]-dp[i][j-1]
                );
            }
        }
        return dp[0][n-1];
    }
    int sol23(int []arr){
        int n = arr.length;
        int []dp = new int[n+1];

    
        for(int i=n-1; i>=0; i--){
            dp[i] = arr[i];
            for(int j=i+1; j<n; j++){
                dp[j] = Math.max(
                    arr[i]-dp[j],arr[j]-dp[j-1]
                );
            }
        }
        return dp[n-1];
    }

    public boolean predictTheWinner(int[] nums) {
        //m-1
        // return sol(nums,0,nums.length-1,0);


        //m-2,3,4 (DP)

        // return sol2(nums,0,nums.length-1)>=0;

        // int n = nums.length;
        // if(n%2 == 0) return true;
        // int [][]dp = new int[n][n];
        // for(int i=0; i<n; i++) Arrays.fill(dp[i],-1);
        // return sol21(nums,0,nums.length-1,dp)>=0;

        // return sol22(nums)>=0
        return sol23(nums)>=0;
    }
}
class Solution {
    int sol(int[]arr, int s, int e){
        if(s>e)return 0;
        int curr = (e-s)*Math.min(arr[s],arr[e]);
        if(arr[s] < arr[e]){
            int a = sol(arr,s+1,e);
            return Math.max(curr,a);
        }
        int b = sol(arr,s,e-1);
        return Math.max(curr,b);
    }
    int sol21(int[] arr) {

        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int l = 1; l < n; l++) {   
            for (int s = 0; s + l < n; s++) {

                int e = s + l;

                int curr = (e - s) * Math.min(arr[s], arr[e]);

                int a = dp[s + 1][e];
                int b = dp[s][e - 1];

                dp[s][e] = Math.max(curr, Math.max(a, b));
            }
        }

        return dp[0][n - 1];
    }
    int sol22(int[]arr){

        int n = arr.length;
        int []dp = new int[n];

        for( int s=n-1; s>=0; s-- ){
            for( int e=s+1; e<n; e++ ){

                int curr = (e-s)*Math.min(arr[s],arr[e]);
                int a = (s+1<n)?dp[e]:0;
                int b = (e-1>=0)?dp[e-1]:0;
                dp[e] = Math.max(curr,Math.max(a,b));

            }
        }

        return dp[n-1];
    }
    // int best(int []a){
    //     in
    // }
    public int maxArea(int[] height) {
        return sol(height,0,height.length-1);
        // return sol2(height);
    }
}
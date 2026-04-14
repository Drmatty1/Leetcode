class Solution {
    int M = Integer.MAX_VALUE;
    int sol(int[]arr, int i, int j, int [][]dp){
        if( i == j ) return 0;
        if( i > j ) return M;

        if( dp[i][j] != 0 ) return dp[i][j];

        int ans = M;
        for( int s=i; s<j; s++ ){
            int l = sol(arr,i,s,dp);
            int r = sol(arr,s+1,j,dp);
            int lmax = 0, rmax =0 ;
            for( int p=i; p<=s; p++ )
                lmax=Math.max(lmax,arr[p]);
            for( int q=s+1; q<=j; q++ )
                rmax=Math.max(rmax,arr[q]);

            ans = Math.min(ans,l+r+lmax*rmax);

        }

        return dp[i][j] = ans;

    }

  
    public int mctFromLeafValues(int[] arr) {
        int [][]dp = new int[40][40];
        return sol(arr,0,arr.length-1,dp);
    }
}
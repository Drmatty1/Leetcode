class Solution {
    int sol(int []arr, int prev, int idx, int k, int [][][]dp, boolean [][][]vis){
        if( k == -1 )return 1;
        if( idx == arr.length ) return 0;

        if( vis[prev+1][idx][k] == true )
            return dp[prev+1][idx][k];

        //take
        int a = 0;
        if( prev == -1 || arr[idx] > arr[prev] ){
            a = sol(arr, idx, idx+1, k-1, dp, vis);
        }

        //skip
        a += sol(arr, prev, idx+1, k, dp, vis);

        vis[prev+1][idx][k] = true;
        return  dp[prev+1][idx][k] = a;
    }
    int sol1(int []arr, int prev, int idx, int k, int[][][]dp, boolean [][][]vis){
        if( k == -1 ) return 1;
        if( idx == arr.length ) return 0;

        if( vis[prev+1][idx][k] == true )
            return dp[prev+1][idx][k];

        //take
        int a = 0;
        if(  prev == -1 || arr[idx] < arr[prev]  ){
            a = sol1(arr, idx, idx+1, k-1, dp, vis);
        }

        //skip
        a += sol1(arr, prev, idx+1, k, dp, vis);

        vis[prev+1][idx][k] = true;
        return  dp[prev+1][idx][k] = a;
    }

    public int numTeams(int[] rating) {
        
        int n = rating.length;

        int [][][]dp = new int[n+1][n][3];
        boolean [][][]vis = new boolean[n+1][n][3];
        int a = sol(rating,-1,0,2,dp,vis);
        
        // dp = new int[n+1][n][4];
        vis = new boolean[n+1][n][3];
        int b = sol1(rating,-1,0,2,dp,vis);

        return a+b;
    } 
}
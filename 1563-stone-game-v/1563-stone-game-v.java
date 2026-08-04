class Solution {
    int []pre;
    int sol(int i, int j, int []arr){
        if(i==j) return 0;
        int ans = 0;
        for(int m=i; m<j; m++){
            int lsum = pre[m+1]-pre[i];
            int rsum = pre[j+1]-pre[m+1];
            int temp = 0;
            if(lsum < rsum){
                temp = lsum + sol(i,m,arr);
            }
            else if(lsum > rsum){
                temp = rsum + sol(m+1,j,arr);
            }
            else{
                temp = Math.max(
                    lsum + sol(i,m,arr),
                    rsum + sol(m+1,j,arr)
                );
            }
            ans = Math.max(ans,temp);
        }
        return ans;
    }
    int sol1(int i, int j, int []arr, int [][]dp){
        if(i==j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        for(int m=i; m<j; m++){
            int lsum = pre[m+1]-pre[i];
            int rsum = pre[j+1]-pre[m+1];
            int temp = 0;
            if(lsum < rsum){
                temp = lsum + sol1(i,m,arr,dp);
            }
            else if(lsum > rsum){
                temp = rsum + sol1(m+1,j,arr,dp);
            }
            else{
                temp = Math.max(
                    lsum + sol1(i,m,arr,dp),
                    rsum + sol1(m+1,j,arr,dp)
                );
            }
            ans = Math.max(ans,temp);
        }
        return dp[i][j] = ans;
    }
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        pre = new int[n+1];
        for(int i=0; i<n; i++)
            pre[i+1] = pre[i]+stoneValue[i];
        
        // return sol(0,n-1,stoneValue);
        int [][]dp = new int[n][n];
        for(int i=0; i<n; i++)Arrays.fill(dp[i],-1);
        return sol1(0,n-1,stoneValue,dp);
    }
}
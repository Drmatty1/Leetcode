class Solution {
    int sol21(int []arr, int i, int j, int[][]dp){
        if(i==j) return arr[i];

        if(dp[i][j] != -1) return dp[i][j];

        int a = arr[i] - sol21(arr,i+1,j,dp);
        int b = arr[j] - sol21(arr,i,j-1,dp);

        return dp[i][j] = Math.max(a,b);
    }
    public boolean stoneGame(int[] piles) {
        // int n = piles.length;
        // int [][]dp = new int[n][n];
        // for(int i=0; i<n; i++) Arrays.fill(dp[i],-1);
        // return sol21(piles,0,n-1,dp)>=0;

        return true;
    }
}

//
// If the array has an  
// even length
// ​
//  , P1 can always force taking either all even-indexed or all odd-indexed elements. By choosing the parity with the larger total sum, P1 is guaranteed at least a tie, so the answer is always true.
class Solution {
    int m,n;
    int s1(int [][]a, int k, int i, int j, int c,int[][][] dp){

        if(i>=m || j>=n) return -1;
        
        int score = a[i][j]; 
        if( c+((a[i][j]!=0)?1:0) > k)  return -1;
        c += (a[i][j]!=0)?1:0;

        if( i==m-1 && j==n-1) return  score;

        // String key=i+" "+j+" "+c;
        if( dp[i][j][c] != -2 ) return dp[i][j][c];

        int d=s1(a,k,i+1,j,c,dp);
        int r=s1(a,k,i,j+1,c,dp);

        int max=Math.max(r,d);
        int ans = (max==-1)?(-1):(score+max);

        // dp.put(key,ans);
        return dp[i][j][c] = ans;
    }
    public int maxPathScore(int[][] grid, int k) {
        m = grid.length; 
        n = grid[0].length;

        // Map<String,Integer> dp = new HashMap<>();
        int[][][] dp = new int[m][n][k+1];
        for(int i=0;i<m;i++)
        for(int j=0;j<n;j++)
            Arrays.fill(dp[i][j], -2);

        return s1(grid,k,0,0,0,dp);
        
    }
}
class Solution {
    int M = 1000000007;
    int [][]dirs = {{-2,-1},{-2,1},{-1,2},{1,2},{2,-1},{2,1},{1,-2},{-1,-2}};
    int [][]a;
    int [][][]dp;
    int sol(int i, int j, int m){
        if(m==1) return 1;
        int ans = 0;
        if(dp[i][j][m] != -1) return dp[i][j][m];

        for(int []d: dirs)
        {
            int ni = i+d[0], nj = j+d[1];
            if(ni<0 || ni>=4 || nj<0 || nj>=3 ) continue;
            if(a[ni][nj] == -1) continue;
            
            ans = (ans+sol(ni,nj,m-1))%M;
        }
        return dp[i][j][m] = ans;

    }
    public int knightDialer(int n) {
        a = new int[4][3];
        a[3][0] = a[3][2] = -1;
        int ans = 0;
        
        dp = new int[4][3][n+1];
        for(int i=0; i<4; i++)
            for(int j=0; j<3; j++)
                Arrays.fill(dp[i][j],-1);

        for(int i=0; i<4; i++){
            for(int j=0; j<3; j++){
                if(a[i][j] == -1) continue;
                ans = (ans+sol(i,j,n))%M;
            }
        }
        return ans;
    }
}
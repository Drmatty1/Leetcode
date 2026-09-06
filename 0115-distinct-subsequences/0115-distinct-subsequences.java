class Solution {
    char []a;
    char []b;
    int [][]dp ;
    int sol(int i, int j){
        if(j==b.length) return 1;
        if(i==a.length) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        if(a[i] == b[j]){
            ans = sol(i+1,j+1);
        }

        ans += sol(i+1,j);

        return dp[i][j] = ans;
    } 
    public int numDistinct(String s, String t) {
        a = s.toCharArray();
        b = t.toCharArray();

        dp = new int[a.length][b.length];
        for(int i=0 ;i<a.length; i++) Arrays.fill(dp[i],-1);
        return sol(0,0);
    }
}
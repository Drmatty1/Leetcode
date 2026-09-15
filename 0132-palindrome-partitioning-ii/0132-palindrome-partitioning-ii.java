class Solution {
    int n ;
    boolean [][]isPal;
    int []dp;
    String str;

    int sol(int i){
        if(i>=n) return 0;

        if(dp[i] != -1) return dp[i];
        int ans = 2000;

        for(int j = i; j<n; j++){
            if(isPal[i][j]){
                ans = Math.min(1+sol(j+1),ans);
            }
        }

        return dp[i] = ans;
    }

    boolean check(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public int minCut(String s) {
        n = s.length();

        isPal = new boolean[n][n];
        dp = new int[n];
        str = s;

        Arrays.fill(dp,-1);

        for(int len=1; len<=n; len++){
            for(int i =0; i<=n-len; i++){
                int j = i+len-1;
                if(s.charAt(i) == s.charAt(j)) 
                    isPal[i][j] = (len <= 2) || isPal[i + 1][j - 1];
            }
        }
        

        return sol(0)-1;
    }
}
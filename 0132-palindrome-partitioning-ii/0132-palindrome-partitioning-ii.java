class Solution {
    int n ;
    // boolean [][]dp;
    int []dp1;
    String str;

    int sol(int i){
        if(i>=n) return 0;

        if(dp1[i] != -1) return dp1[i];
        int ans = 2000;

        for(int j = i; j<n; j++){
            if(check(str,i,j)){
                // System.out.println(i+"-"+j);
                ans = Math.min(1+sol(j+1),ans);
            }
        }

        return dp1[i] = ans;
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

        // dp = new boolean[n][n];
        dp1 = new int[n];
        str = s;

        Arrays.fill(dp1,-1);

        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n; j++){
        //         dp[i][j] = check(s,i,j);
        //     }
        // }

        return sol(0)-1;
    }
}
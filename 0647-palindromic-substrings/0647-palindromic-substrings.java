class Solution {
    int count(char []a, int i, int j){

        int n = a.length;
        int count = 0;

        while(i>=0 && j<n){
            if(a[i--] == a[j++]) count++;
            else break;
        }

        return count;
    }
    int sol_OP(String s) {
        char []a = s.toCharArray();
        int n = a.length;
        int ans = 0;
        for(int i=0; i<n; i++){
            ans += count(a,i,i+1); //even length;
            ans += 1+count(a,i-1,i+1); //odd length;
        }
        return ans;
    }

    int sol2(String s){

        int n  = s.length();
        boolean [][]dp = new boolean[n][n];

        for(int i=0; i<n; i++) dp[i][i] = true;

        char []a = s.toCharArray();
        int count = 0 ;

        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
                if(a[i] == a[j] && ( j-i < 2 || dp[i+1][j-1] ) ){
                    count++;
                    dp[i][j] = true;
                }
            }
        }

        return count;

    }
    public int countSubstrings(String s) {
        return sol2(s);
    }
}
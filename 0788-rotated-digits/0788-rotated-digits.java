class Solution {
    static int []dp = new int[10001];
    static int max=1;
    int c(int n){
        int check = 0;
        while(n>0){
            int t = n%10;
            if(t==2||t==5||t==6||t==9) check=1;
            if( t==3||t==4||t==7)return 0;
            n = n/10;
        }
        return check;
    }
    public int rotatedDigits(int n) {
        int ans = 0;
        if( n <= max ) return dp[n];

        for(int i=max+1; i<=n; i++){
            int t = c(i);
            dp[i] = t+dp[i-1];
        }
        max = n;
        return dp[n];
    }
}
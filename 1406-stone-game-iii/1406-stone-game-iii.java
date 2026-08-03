class Solution {
    int solve( int[] p, int i, int []suff ){
        int l = p.length;
        if( i >= l ) return 0;
        int sum = 0;
        int ans = (int)-1e8;
        for( int t=i; t<i+3 && t<l; t++ ){
            sum += p[t];
            int a = solve( p, t+1, suff );  
            ans = Math.max(ans,sum+suff[t+1]-a);
        }
        return ans;
    }

    int solve1( int[] p, int i, int []suff, int []dp ){
        int l = p.length;
        if( i >= l ) return 0;
        int sum = 0;
        int ans = (int)-1e8;
        if(dp[i] != -1) return dp[i];
        for( int t=i; t<i+3 && t<l; t++ ){
            sum += p[t];
            int a = solve1( p, t+1, suff, dp );  
            ans = Math.max(ans,sum+suff[t+1]-a);
        }
        return dp[i] = ans;
    }
    
    public String stoneGameIII(int[] stoneValue) {
        int l = stoneValue.length;
        int []suff = new int[l+1];
        for( int i=l-1; i>=0; i-- ){
            suff[i] = suff[i+1]+stoneValue[i];
        }

        // int score = solve(stoneValue,0,suff);

        int []dp = new int[l];
        Arrays.fill(dp,-1);
        int score = solve1(stoneValue,0,suff,dp);


        int sum = suff[0];
        System.out.println(score);

        if(score*2 > sum) return "Alice";
        else if (score*2 < sum) return "Bob";
        return "Tie";
    }
}
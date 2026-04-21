class Solution {
    int Max = Integer.MAX_VALUE;
    int ct(String s){
        int res=0;
        for(char c: s.toCharArray()){
            res += c-'0';
        }
        return res;
    }

    int sol(Map<String,Integer> map, String[] strs, int m, int n, int i, int p, int q){

        if(i==strs.length)return 0;

        int a = sol(map,strs,m,n,i+1,p,q);

        int one = map.get(strs[i]);
        int zero = strs[i].length()-one;
        int b = 0;
        if( m >= p+zero && n>= q+one ){
            b = 1+sol(map,strs,m,n,i+1,p+zero,q+one);
        }

        return Math.max(a,b);
        
    }

    int sol1(Map<String,Integer> map, String[] strs, int m, int n, int i, int p, int q, int [][][]dp){

        if(i==strs.length)return 0;

        // String key = i+" "+p+" "+q;
        // int key = (i << 14) | (p << 7) | q;

        // if(dp.containsKey(key)) return dp.get(key);
        if( dp[i][p][q] != -1 ) return dp[i][p][q];
        
        //skip
        int a = sol1(map,strs,m,n,i+1,p,q,dp);

        // take
        int one = map.get(strs[i]);
        int zero = strs[i].length()-one;
        int b = 0;
        if( m >= p+zero && n>= q+one ){
            b = 1+sol1(map,strs,m,n,i+1,p+zero,q+one,dp);
        }

        // dp.put(key,(Math.max(a,b)));
        return dp[i][p][q] = Math.max(a,b);
        
    }

    int sol1BottomUp(Map<String, Integer> map, String[] strs, int m, int n) {
    int len = strs.length;
    
   
    int[][][] dp = new int[len + 1][m + 1][n + 1];
    

    // 1. Iterate backwards through the strings
    for (int i = len - 1; i >= 0; i--) {
        
        int one = map.get(strs[i]);
        int zero = strs[i].length() - one;
        
        // We go from m down to 0, and n down to 0
        // as so to get true 2d dp soln
        for (int p = m; p >= 0; p--) {
            for (int q = n; q >= 0; q--) {
                
                // (skip)
                int a = dp[i + 1][p][q];
                
                // (take)
                int b = 0;
                if (m >= p + zero && n >= q + one) {
                    b = 1 + dp[i + 1][p + zero][q + one];
                }
                
                // Exact match to your return statement
                dp[i][p][q] = Math.max(a, b);
            }
        }
    }
    
    return dp[0][0][0];
}

    public int findMaxForm(String[] strs, int m, int n) {
        Map<String,Integer> map = new HashMap<>();
        for(String s: strs){
            if( !map.containsKey(s) )
                map.put(s,ct(s));
        }

        // Recurrsion
        // int ans = sol(map,strs,m,n,0,0,0);

        // Memo
        // Map<Integer,Integer> dp = new HashMap<>();
        // int [][][]dp = new int[strs.length][101][101];
        // for(int i=0; i<strs.length; i++){
        //     for(int j=0; j<=100; j++)Arrays.fill(dp[i][j],-1);
        // }
        // int ans = sol1(map,strs,m,n,0,0,0,dp);
        // return ans;

        //bottom up
        return sol1BottomUp(map,strs,m,n);
    }
}
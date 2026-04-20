class Solution {
    int sol(List<List<Integer>> t, int l, int i){
        if(l == t.size()) return 0;
    
        int a = sol(t,l+1,i);
        int b = sol(t,l+1,i+1);

        return t.get(l).get(i)+Math.min(a,b);

    }

    int sol1(List<List<Integer>> t, int l, int i, int [][]dp){
        
        // if(l == t.size()) return 0;
        if( l == t.size()-1 ){
            return t.get(l).get(i);
        }
    
        if(dp[l][i] != Integer.MIN_VALUE) return dp[l][i];

        int a = sol1(t,l+1,i, dp);
        int b = sol1(t,l+1,i+1, dp);

        return dp[l][i] = t.get(l).get(i)+Math.min(a,b);

    }
    public int minimumTotal(List<List<Integer>> triangle) {
        // return sol(triangle,0,0);

        int l = triangle.size();
        int Min = Integer.MIN_VALUE;
        int [][]dp = new int [l][l];
        for(int i=0; i<l; i++)Arrays.fill(dp[i],Min);
        return sol1(triangle,0,0,dp);
    }
}
class Solution {
    int dfs(List<List<Integer>> adj, int i, int[]it ){   
        
        int ans= 0;
        for( int n : adj.get(i) ){
        
            int res = it[i] + dfs(adj,n,it);
            ans = Math.max(ans, res);
        
        }
        return ans;
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        List<List<Integer>> adj = new ArrayList<>();

        for( int i=0; i<n; i++ ){
            adj.add(new ArrayList<>());
        }
        for( int i=0; i<n; i++ ){
            int a = i;
            int b = manager[i];
            if( b != -1 ) adj.get(b).add(a);
        }
    
        int ans = dfs(adj, headID, informTime );
        return  ans;
    }
}
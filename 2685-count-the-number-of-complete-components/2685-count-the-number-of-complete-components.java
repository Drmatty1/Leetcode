class Solution {

    int count(int n, List<List<Integer>> adj, boolean []vis ){
        vis[n] = true;
        int ans = 1;
        for(int next: adj.get(n)){
            if(vis[next] == false)
                ans += count(next,adj,vis);
        }
       return ans;
    }

    boolean dfs(int n, int max, List<List<Integer>> adj, boolean []vis ){
        boolean ans = false;
        vis[n] = true;
        for(int next: adj.get(n)){
            if(vis[next] == false)
                ans |= dfs(next,max,adj,vis);
        }

        if(max!=adj.get(n).size()) return true;
        return ans;
    }

    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int []e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean []vis = new boolean[n];
        boolean []vis1 = new boolean[n];
        int ans = 0;
        for(int i=0; i<n; i++){
            if(vis[i] == false){
                int max = count(i,adj,vis1);
                ans += dfs(i,max-1,adj,vis)?0:1;
            }
        }
        return ans;
    }
}
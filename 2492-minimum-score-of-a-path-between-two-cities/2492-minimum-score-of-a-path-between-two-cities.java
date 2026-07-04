class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());
        for(int []e: roads){
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        boolean []vis = new boolean[n+1];
        q.add(1);
        vis[1] = true;

        while(!q.isEmpty()){
            int s = q.size();
            for(int t=0; t<s; t++){
                int u = q.poll();
                
                for( int next: adj.get(u) ){
                    int v = next;
                    if(vis[v] == false){
                        vis[v] = true;
                        q.add(v);
                    }
                }
            }
        }

        int ans = 10000;

        for(int []e: roads){
            int u = e[0], v = e[1], w = e[2];
            if( vis[u] == true ) ans = Math.min(ans, w);
        }
        

        return ans;
    }
}
class Solution {
    void dfs(List<List<Integer>> adj, boolean []mark, int k){
        mark[k] = true;
        // System.out.println(k+" ");
        for(int n: adj.get(k)){
            // System.out.println(k+" "+n);
            if(mark[n] == false){
                dfs(adj,mark,n);
            }
        }
    }
    boolean dfs1(List<List<Integer>> adj,boolean []vis, boolean []mark, int k){

        if(mark[k] == true) return true;

        boolean res = false;
        vis[k] = true;

        for(int n: adj.get(k)){
            if(vis[n] == false){
                res |= dfs1(adj,vis,mark,n);
            }
        }

        return res;
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int []a: invocations){
            int u = a[0];
            int v = a[1];
            adj.get(u).add(v);
        }

        boolean []mark = new boolean[n];
        dfs(adj,mark,k);


        boolean []vis = new boolean[n];
        boolean ans = false;
        for(int i=0; i<n; i++)
            if(vis[i] == false && mark[i] == false)
                ans |= dfs1(adj,vis,mark,i);
        
        // System.out.println(ans);
        // for(int i=0; i<n; i++){
        //     System.out.print(vis[i]+" ");
        // }

        List<Integer> res = new ArrayList<>();

        if(ans) {
            for(int i=0; i<n; i++){
                    res.add(i);
            }
            return res;
        }
        else{
            for(int i=0; i<n; i++){
                if(mark[i]==false)
                    res.add(i);
            }
            return res;
        }

    }
}









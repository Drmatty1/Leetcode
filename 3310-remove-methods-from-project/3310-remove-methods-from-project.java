class Solution {

    void dfs(List<List<Integer>> adj, boolean []mark, int k){
        mark[k] = true;
        for(int n: adj.get(k)){
            if(mark[n] == false){
                dfs(adj,mark,n);
            }
        }
    }

    void dfs_it(List<List<Integer>> adj, boolean[] mark, int start) {
        Stack<Integer> st = new Stack<>();
        st.push(start);

        while (!st.isEmpty()) {
            int node = st.pop();

            if (mark[node])
                continue;

            mark[node] = true;

            for (int next : adj.get(node))
                if (!mark[next])
                    st.push(next);
        }
    }

    boolean dfs1(List<List<Integer>> adj,boolean []vis, boolean []mark, int k){

        if(mark[k] == true) return true;

        vis[k] = true;

        for (int next : adj.get(k)) {
            if (!vis[next] && dfs1(adj, vis, mark, next)) {
                return true;
            }
        }

        return false;

    }

    boolean dfs1_it(List<List<Integer>> adj,boolean []vis, boolean []mark, int k){

        Stack<Integer> st = new Stack<>();
        st.push(k);

         while (!st.isEmpty()) {

            int n = st.pop();

            if (mark[n]) return true;

            vis[n] = true;

            for (int next : adj.get(n)) {
                if (!vis[next] ) {
                    st.push(next);
                }
            }
        }

        return false;

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
            if(vis[i] == false && mark[i] == false){
                ans |= dfs1(adj,vis,mark,i);
                // ans |= dfs1_it(adj,vis,mark,i);
                if(ans) break;
            }
       

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









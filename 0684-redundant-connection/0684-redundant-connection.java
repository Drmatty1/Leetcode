class Solution {
    class DSU{
        int []par;
        int n;
        DSU(int n){
            this.n = n;
            par = new int[n];
            for(int i=0; i<n; i++){
                par[i] = i;
            }
        }

        int find(int a){
            if(par[a] == a) return a;
            return par[a] = find(par[a]);
        }

        boolean union(int[] e){
            int a = e[0], b = e[1];
            int pa = find(a), pb = find(b);
            if(pa == pb) return false;
    
            par[pa] = pb;
            return true;
        }

    }
    public int[] findRedundantConnection(int[][] edges) {
        DSU d = new DSU(edges.length+1);
        for(int []e: edges){
            if(d.union(e) == false) return e;
        }
        return new int[]{-1,-1};
    }
}
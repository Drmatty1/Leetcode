class Solution {
   
    class UnionFind{
        int []parent, rank;
        UnionFind(int n){
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }
        
        public boolean union(int x, int y) {
            int rx = find(x);
            int ry = find(y);

            if (rx == ry) return false; // cycle

            // union by rank
            if (rank[rx] < rank[ry]) {
                parent[rx] = ry;
            } else if (rank[rx] > rank[ry]) {
                parent[ry] = rx;
            } else {
                parent[ry] = rx;
                rank[rx]++; // increase only when equal
            }
            return true;
        }


        
    }
    boolean matchU(int c, int u){
        if( u == 2 || u == 3 || u == 4  ){
            return (c==2||c==5||c==6);
        }
        return false;
    }
    boolean matchL(int c, int l){
        if( l == 1 || l == 4 || l == 6  ){
            return (c==1||c==3||c==5);
        }
        return false;
    }
    boolean solDSU(int [][]grid){
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(m * n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int id = i * n + j;

                // UP
                if (i > 0 && matchU(grid[i][j],grid[i-1][j])){
                    int up = (i - 1) * n + j;
                    uf.union(id, up);
                }

                // LEFT
                if (j > 0 && matchL(grid[i][j],grid[i][j-1]))
                {
                    int left = i * n + (j - 1);
                    uf.union(id, left);
                }
            }
        }
        if(uf.find(0) == uf.find(m*n-1)) return true;
        return false;
    }
    public boolean hasValidPath(int[][] grid) {
        return solDSU(grid);
    }
}
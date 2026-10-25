class Solution {
    int [][]dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    int r , c;
    boolean dfs(int [][]arr, int i, int j){
        if( i == r-1 || i==0 || j==c-1 || j==0) return true;

        arr[i][j] = 1;
        boolean ans = false;
        for(int []d: dirs){
            int ni = i+d[0];
            int nj = j+d[1];
            if((ni>=0 && ni<r && nj>=0 && nj<c) && arr[ni][nj]==0){
                ans |= dfs(arr, ni, nj);
            }
        }
        return ans;
    }
    public int closedIsland(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        int ans = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == 0 && !dfs(grid,i,j)) ans++;
            }
        }
        return ans;
    }
}
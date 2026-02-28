class Solution {
    int[][]dir = {{0,1},{0,-1},{1,0},{-1,0}};

    void dfs(int[][] grid, int[][] visited, int i, int j, int []flag){
        
        int r = grid.length, c = grid[0].length;
        if( i>=r || i<0 || j>=c || j<0 )  return ;
        
        visited[i][j] = 1;
        if( (i == r-1 || i==0 || j == c-1 || j == 0) && grid[i][j]==0 ){
            flag[0] = 0;
        }
        
        for( int[]d : dir ){
            int a = i+d[0];
            int b = j+d[1];
            boolean inGrid = (a>=r || a<0 || b>=c || b<0);
            if( !inGrid && visited[a][b]==0 && grid[a][b]==0 ){
                dfs(grid,visited,a,b,flag);
            }
        }

    }

    //dfs without visited array -> Modifying original grid
    void dfs1(int[][] grid, int i, int j, int []flag){
        
        int r = grid.length, c = grid[0].length;
        if( i>=r || i<0 || j>=c || j<0 )  return ;
        
        if( (i == r-1 || i==0 || j == c-1 || j == 0) && grid[i][j]==0 ){
            flag[0] = 0;
        }
        grid[i][j] = 1;
        
        for( int[]d : dir ){
            int a = i+d[0];
            int b = j+d[1];
            boolean inGrid = (a>=r || a<0 || b>=c || b<0);
            if( !inGrid && grid[a][b]==0 ){
                dfs1(grid,a,b,flag);
            }
        }

    }
    public int closedIsland(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        // int[][] visited = new int[r][c];
        int count = 0;
        for( int i=0; i<r; i++ ){
            for(int j=0; j<c; j++){
                if( grid[i][j]==0 ){
                    int[]flag = {1};
                    // dfs(grid,visited,i,j,flag);
                    dfs1(grid,i,j,flag);
                    if( flag[0] == 1 ) count++;
                }
            }
        }
        return count;
    }
}
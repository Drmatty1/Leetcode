class Solution {
    void bfs(int[][]grid){

        int m = grid.length, n =  grid[0].length;
        Queue<Integer> q = new ArrayDeque<>();
        int [][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
        
        int good = 0;
        for( int i=0; i<m; i++ ){
            for( int j=0; j<n; j++ ){
                if(grid[i][j]==1){ 
                    q.add(i*n+j);
                    grid[i][j] = 0;
                }
                else grid[i][j] = -1;
            }
        }
       
        int count = 1;
        while ( !q.isEmpty() ){
            
            int curr=q.poll();
            int i = curr/n, j = curr%n;

            for( int[]d : dir ){

                int ni = i + d[0];
                int nj = j + d[1];
                
                if( ni>=0 && ni<m && nj>=0 && nj<n && grid[ni][nj]==-1){
                    q.add(ni*n+nj);
                    grid[ni][nj] = grid[i][j]+1;
                }
            }
    
        }
       
        return ;
    }
    public int[][] highestPeak(int[][] isWater){
        bfs(isWater);
        return isWater;
    }
}
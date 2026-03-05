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
                    grid[i][j] = -1;
                }
            }
        }
       
        int count = 1;
        while ( !q.isEmpty() ){
            
            int size = q.size();
            boolean flag = false;
            for( int i=0; i<size; i++ ){
                
                int curr=q.poll();
                for( int[]d : dir ){

                    int ni = curr/n + d[0];
                    int nj = curr%n + d[1];
                   
                    if( ni>=0 && ni<m && nj>=0 && nj<n && grid[ni][nj]==0){
                        q.add(ni*n+nj);
                        grid[ni][nj] = count;
                
                    }
                }
            }
            count++;
        }
        for( int i=0; i<m; i++ ){
            for( int j=0; j<n; j++ ){
                if(grid[i][j]==-1){ 
                    grid[i][j] = 0;
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
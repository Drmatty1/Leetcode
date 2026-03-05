class Solution {
    
    int bfs(int[][]grid){
        int m = grid.length, n =  grid[0].length;
        Queue<Integer> q = new ArrayDeque<>();
        int [][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int good = 0;
        for( int i=0; i<m; i++ ){
            for( int j=0; j<n; j++ ){
                if(grid[i][j]==2){ 
                    q.add(i*n+j);
                }
                else if( grid[i][j] == 1 ) good++;
            }
        }
       
        int count = 0;
        while ( !q.isEmpty() ){
            
            int size = q.size();
            boolean flag = false;
            for( int i=0; i<size; i++ ){
                
                int curr=q.poll();
                for( int[]d : dir ){

                    int ni = curr/n + d[0];
                    int nj = curr%n + d[1];
                   
                    if( ni>=0 && ni<m && nj>=0 && nj<n && grid[ni][nj]==1){
                        
                        q.add(ni*n+nj);
                        grid[ni][nj] = 2;
                        good--;
                        flag = true;
                    }
                }
            }

           if(flag==true) count++;
        }

        return good==0?count:-1;
    }
    public int orangesRotting(int[][] grid) {
        return bfs(grid);
    }
}
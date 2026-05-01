class Solution {
    int [][]dir = {{0,1},{1,0},{0,-1},{-1,0}};
    int r,c;
    boolean dfs(char[][]grid, int i, int j, int pi, int pj, char t){
        
        grid[i][j] = t ;
        
        boolean ans = false;
        char curr = grid[i][j];

        for(int []d : dir){
            int ni = i+d[0];
            int nj = j+d[1];
            if(ni>=0 && ni<r && nj>=0 && nj<c ){
                if(ni == pi && nj == pj) continue;
               
                if(grid[ni][nj] == curr) return true;
                if(grid[ni][nj] == (curr+32)){
                    ans |= dfs(grid,ni,nj,i,j,t);
                    if(ans == true)return true;
                }
                
                    
            }
        }

        return ans;
    }
    public boolean containsCycle(char[][] grid) {
        r = grid.length;
        c = grid[0].length;
        boolean ans= false;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                char c = grid[i][j];
                if( c<= 'z' && c>='a' ){
                    ans |= dfs(grid,i,j,-1,-1,(char)(c-32));
                    if(ans == true)return true;
                }
            }
        }
        return ans;
    }
}
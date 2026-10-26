class Solution {
    int [][]a;
    int r,c;
    int [][]dir = {{0,1},{0,-1},{1,0},{-1,0}};

    long dfs(int i, int j){

        long ans = 0;
        ans += a[i][j];
        a[i][j]=0;

        for(int []d: dir){
            int ni = i+d[0], nj = j+d[1];
            if(ni>=0 && ni<r && nj>=0 && nj<c && a[ni][nj]>0){
                ans += dfs(ni,nj);
            }
        }
        return ans;
    }
    public int countIslands(int[][] grid, int k) {
        a = grid;
        r = grid.length;
        c = grid[0].length;
        int res= 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(a[i][j]>0 && dfs(i,j)%k==0)  res++;
            }
        }
        return res;
    }
}
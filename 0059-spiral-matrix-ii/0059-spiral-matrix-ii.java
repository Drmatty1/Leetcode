class Solution {
    int [][]dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    int n;
    
    void dfs(int x, int y, int[][] arr, int k, int d){

        arr[x][y] = k;

        if (k == n * n) return;

        int nx = x+dirs[d][0];
        int ny = y+dirs[d][1];

        if( nx<0 || nx>=n || ny<0 || ny>=n || arr[nx][ny] != -1 ){
            d = (d+1)%4;
            nx = x+dirs[d][0];
            ny = y+dirs[d][1];

        }

        dfs(nx,ny,arr,k+1,d);

    }
    public int[][] generateMatrix(int n) {
        this.n = n;
        int [][]arr = new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(arr[i],-1);


        dfs(0,0,arr,1,0);

        return arr;
    }
}
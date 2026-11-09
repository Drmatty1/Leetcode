class Solution {
    public int countServers(int[][] grid) {
        int r = grid.length, c=grid[0].length;
        int []rc = new int[r];
        int []cc = new int[c]; //one line?

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                rc[i] += grid[i][j];
                cc[j] += grid[i][j];
            }
        }
        int ans = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(rc[i]>1 || cc[j]>1) ans += grid[i][j];
            }
        }
        return ans;
    }
}
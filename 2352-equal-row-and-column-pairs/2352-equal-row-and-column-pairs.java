class Solution {
    int check(int [][]a, int[][]b, int i, int j){
        for(int k = 0; k < a.length; k++){
            if(a[i][k] != b[j][k]) return 0;
        }
        return 1;
    }
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int [][]cgrid = new int[n][n];

        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                cgrid[j][i] = grid[i][j];

        int []colHash = new int[n];
        for(int i=0; i<n; i++) colHash[i]=Arrays.hashCode(cgrid[i]);

        int ans = 0;
        for(int i=0; i<n; i++){
            int rowHash = Arrays.hashCode(grid[i]);
            for(int j=0; j<n; j++){
                if( rowHash != colHash[j] ) continue;
                ans += check(grid,cgrid,i,j);
            }
        }

        return ans;
        
    }
}
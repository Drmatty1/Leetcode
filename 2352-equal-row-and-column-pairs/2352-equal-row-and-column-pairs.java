class Solution {
    String hashCode(int []arr){
        long h1 = 0;
        long h2 = 0;

        for (int x : arr) {
            h1 = h1 * 1000003L + x;
            h2 = h2 * 1000033L + x;
        }
        return h1+"-"+h2;
    }
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

        String []colHash = new String[n];
        for(int i=0; i<n; i++) colHash[i] = hashCode(cgrid[i]);

        int ans = 0;
        for(int i=0; i<n; i++){
            String rowHash = hashCode(grid[i]);
            for(int j=0; j<n; j++){
                if( !rowHash.equals(colHash[j]) ) continue;
                ans += check(grid,cgrid,i,j);
            }
        }

        return ans;
        
    }
}
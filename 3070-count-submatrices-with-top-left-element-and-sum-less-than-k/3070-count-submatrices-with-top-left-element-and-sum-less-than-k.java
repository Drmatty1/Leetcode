class Solution {
    void add( int []a, int[]b ){
        int l = a.length;
        for( int i=0; i<l; i++ ) a[i] += b[i];
    }
    public int countSubmatrices(int[][] grid, int k) {
        
        int r = grid.length, c = grid[0].length;
        int ans = 0;
       
        for( int i = 0; i<r; i++ ){

            if( i != 0 ) add( grid[0], grid[i] );

            int sum = 0;
            for( int j=0; j<c; j++ ){
                sum += grid[0][j];
                if( sum <= k ) ans++;
            }

        }
        return ans;
    }
}
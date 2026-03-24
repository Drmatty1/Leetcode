class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int M = 12345;

        int []row = new int[r];

        for( int i=0; i<r; i++ ){
            row[i] = 1;
            for(int j =0; j<c; j++){
                row[i] = (int)((1L*row[i]*grid[i][j])%M);
            }
        }

        int[]ps = new int[r];
        ps[r-1] = row[r-1];
        for( int i=r-2; i>=0; i-- ){
            ps[i] = (int)((1L*ps[i+1]*row[i]) % M) ;
        }

        int [][]ans = new int[r][c];
        long q = 1;

        for( int i=0; i<r; i++ ){
            int [] s = new int[c];
            
            s[c-1] = grid[i][c-1];
            for(int j =c-2; j>=0; j--){
                s[j] = (int)((1L*s[j+1]*grid[i][j])%M); 
            }

            long p = 1;
            long nextRows = (i+1==r)?1:ps[i+1];

            for( int j=0; j<c; j++ ){
                long n = (j+1)==c?1:s[j+1];
                ans[i][j] = (int)((p*q*n)%M);
                ans[i][j] = (int)((ans[i][j]*nextRows)%M);
                p = (p*grid[i][j])%M;
            }
            q = (q*row[i])%M;
        }
        return ans;
    }
}
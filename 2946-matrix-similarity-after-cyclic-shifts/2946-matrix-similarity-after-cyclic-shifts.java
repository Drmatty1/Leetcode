class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int r = mat.length, c = mat[0].length;
        if( k%c == 0  ) return true;
        k = k%c;

        // odd rows
        for( int i=1; i<r; i+=2 ){
            for( int j=0; j<c; j++ ){
                if( mat[i][j] != mat[i][(j+k)%c] ) return false;
            }
        }

        // even rows rows
        for( int i=0; i<r; i+=2 ){
            for( int j=0; j<c; j++ ){
                if( mat[i][j] != mat[i][(j+c-k)%c] ) return false;
            }
        }

        return true;
    }
}
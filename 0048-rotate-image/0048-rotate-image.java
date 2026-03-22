class Solution {
    public void rotate(int[][] matrix) {
        int [][]m = matrix;
        int n = m.length; 
        for( int i=0; i<n; i++ ){
            for( int j=i+1; j<n; j++ ){
                int t = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = t;
            }
        }
        for( int i=0; i<n; i++ ){
            for( int j=0; j<n/2; j++ ){
                int t = m[i][j];
                m[i][j] = m[i][n-j-1];
                m[i][n-j-1] = t;
            }
        }
        return ;
    }
}
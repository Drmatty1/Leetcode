class Solution {
public:
    void put( vector<vector<int>>& matrix , int v, int i, int j, int x, int y, int n){
        int ni = j ;
        int nj = n-i-1;

        if( x == ni && y == nj ){
            matrix[ni][nj] = v;
            return ;
        }
        int temp = matrix[ni][nj];
        matrix[ni][nj] = v;

        put(matrix, temp, ni,nj, x, y, n );

    }
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        for( int i=0; i<n/2; i++ ){
            for( int j=i; j<n-i-1; j++){
                put( matrix, matrix[i][j], i, j, i, j, n );
            }
        }
    }
    // transpose + mirror ; Brilliant
    // alt : observe (x,y) -> (y,n-1-x); 
};


















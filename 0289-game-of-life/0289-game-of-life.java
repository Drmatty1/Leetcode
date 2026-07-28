class Solution {

    int [][]dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
    int r , c;

    int countNeigh(int i, int j, int [][]b){
        int count = 0;
        for(int []dir: dirs){
            int ni = i+dir[0];
            int nj = j+dir[1];
            if(ni<0 || nj<0 || ni>=r || nj >=c ) continue;
            count += b[ni][nj];
        }
        return count;
    }
    public void gameOfLife(int[][] board) {

        r = board.length;
        c = board[0].length;
        int [][]ans = new int[r][c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){

                int c = countNeigh(i,j,board);
                
                //live cell
                if(board[i][j] == 1){
                    if(c<2) ans[i][j] = 0;
                    else if(c==2||c==3) ans[i][j] = 1;
                    else ans[i][j] = 0;
                }
                //dead cell
                else{
                    if(c==3) ans[i][j] = 1;
                }
            }
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                board[i][j] = ans[i][j];
            }
        }

        return;
    }
}
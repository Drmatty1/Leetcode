class Solution {
    int r,c;
    int [][]dirs = {{0,1},{0,-1},{1,0},{-1,0}};

    void mark(char[][] board, int i, int j){
        if(i<0 || i>=r || j<0 || j>=c) return ;
        if(board[i][j] != 'O') return ;

        board[i][j] = '#';

        for(int []d: dirs){
            int ni = i+d[0];
            int nj = j+d[1];
            mark(board,ni,nj);
        }

        return ;
    }

    public void solve(char[][] board) {
        r = board.length;
        c = board[0].length;

        // marking gaureented safe O as #
        for(int i=0; i<r; i++){
            // first col 
            if(board[i][0] == 'O'){
                mark(board,i,0);
            }
            // last col
            if(board[i][c-1] == 'O'){
                mark(board,i,c-1);
            }
        }
        for(int j=0; j<c; j++){
            // first row 
            if(board[0][j] == 'O'){
                mark(board,0,j);
            }
            // last row
            if(board[r-1][j] == 'O'){
                mark(board,r-1,j);
            }
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(board[i][j] == '#') board[i][j] = 'O';
            }
        }

        return ;
    }
}
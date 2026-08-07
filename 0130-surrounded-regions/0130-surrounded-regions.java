class Solution {
    int r,c;
    int [][]dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    boolean canEscape(char[][] board, int i, int j, boolean [][]vis){
        if(i<0 || i>=r || j<0 || j>=c) return true;
        if(board[i][j] == 'X') return false;
        if(vis[i][j]) return false;
        vis[i][j] = true;

        for(int []d: dirs){
            int ni = i+d[0];
            int nj = j+d[1];
            if(canEscape(board,ni,nj,vis)) return true;
        }
        return false;
    }
    void fill(char[][] board, int i, int j){
        if(i<0 || i>=r || j<0 || j>=c) return ;
        if(board[i][j] == 'X') return ;

        board[i][j] = 'X';

        for(int []d: dirs){
            int ni = i+d[0];
            int nj = j+d[1];
            fill(board,ni,nj);
        }

        return ;
    }
    public void solve(char[][] board) {
        r = board.length;
        c = board[0].length;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(board[i][j] == 'O'){
                    boolean [][]vis = new boolean[r][c];
                    if(!canEscape(board,i,j,vis)){
                        fill(board,i,j);
                    }
                }
            }
        }
        return ;
    }
}
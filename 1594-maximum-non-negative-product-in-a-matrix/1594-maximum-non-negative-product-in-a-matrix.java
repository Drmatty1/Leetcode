class Solution {
    class Pair{
        long a;
        long b;
        Pair(long x, long y){
            a=x;
            b=y;
        }
    };

    Pair sol(int[][] g, int i, int j){
        if( i == g.length-1 && j == g[0].length-1 ) 
            return new Pair(g[i][j],g[i][j]);

        if( i+1 == g.length ){
            Pair b = sol(g, i, j+1);
            return new Pair(g[i][j]*(b.a),g[i][j]*(b.b));
        }
        else if( j+1 == g[0].length ){
            Pair a = sol(g, i+1, j);
            return new Pair(g[i][j]*a.a,g[i][j]*a.b);
        }
        else{
            Pair a = sol(g, i+1, j);
            Pair b = sol(g, i, j+1);
            long c = g[i][j];
            long op1 = Math.max( Math.max(c*a.a,c*a.b), Math.max(c*b.a,c*b.b) );
            long op2 = Math.min( Math.min(c*a.a,c*a.b), Math.min(c*b.a,c*b.b) );
            return new Pair(op1,op2);
        }
        
    }

    long[] sol1(int[][] g, int i, int j, long[][][]dp){
        if( i == g.length-1 && j == g[0].length-1 ) 
            return new long[]{g[i][j],g[i][j]};

        if( dp[i][j][0] != 0L && dp[i][j][1] != 0L ) return dp[i][j];

        if( i+1 == g.length ){
            long[] b = sol1(g, i, j+1, dp);
            dp[i][j] = new long[]{g[i][j]*(b[0]),g[i][j]*(b[1])};
            return dp[i][j];
        }
        else if( j+1 == g[0].length ){
            long[] a = sol1(g, i+1, j, dp);
            dp[i][j] = new long[]{g[i][j]*a[0],g[i][j]*a[1]};
            return dp[i][j];
        }
        else{
            long[] a = sol1(g, i+1, j, dp);
            long[] b = sol1(g, i, j+1, dp);
            long c = g[i][j];
            long op1 = Math.max( Math.max(c*a[0],c*a[1]), Math.max(c*b[0],c*b[1]) );
            long op2 = Math.min( Math.min(c*a[0],c*a[1]), Math.min(c*b[0],c*b[1]) );
            dp[i][j] = new long[]{op1,op2};
            return dp[i][j];
        }
        
    }

    public int maxProductPath(int[][] grid) {
        long m = 1000000007;
        long [][][]dp = new long[grid.length][grid[0].length][2];
        // Pair res = sol(grid,0,0);
        long[] res = sol1(grid,0,0,dp);
        long ans = res[0];
        if( ans < 0 ) return -1;
        return (int)(ans%m);
    }
}
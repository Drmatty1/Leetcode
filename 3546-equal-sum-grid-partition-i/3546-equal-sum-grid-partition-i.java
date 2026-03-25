class Solution {
    boolean check( long[]arr, long t ){
        int l = arr.length;
        long cs = 0;
        for( int i=0; i<l; i++ ){
            cs += arr[i];
            if( cs == t ) return true;
            if( cs > t ) return false;
        }
        return false;
    }
    public boolean canPartitionGrid(int[][] grid) {
        long sum = 0;
        int r = grid.length, c = grid[0].length;
        long []rs = new long[r];
        long []cs = new long[c];

        for( int i=0; i<r; i++ ){
            for( int j=0; j<c; j++ ){
                rs[i] += grid[i][j];
                cs[j] += grid[i][j];
                sum += grid[i][j];
            }
        }
        if( sum%2 != 0 ) return false;

        sum = sum>>1;  // now sum is target

        boolean op1 = check(rs, sum);
        if( op1 == true ) return true;

        op1 = check(cs, sum);

        return op1;

    }
}
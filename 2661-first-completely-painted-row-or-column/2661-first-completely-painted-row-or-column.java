class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n=mat[0].length, l = arr.length;
        Map<Integer,Long> map = new HashMap<>();
        for( int i=0; i<m; i++ ){
            for( int j=0; j<n; j++ ){
                int key = mat[i][j];
                map.put(key, ( (long)i<<18 ) | j );
            }
        }
        int []row = new int[m];
        int []col = new int[n];
        for( int i=0; i<l; i++ ){
            long t = map.get(arr[i]);
            int r = (int)(t>>18), c = (int)(t&((1<<18)-1));
            row[r] ++;
            col[c] ++;
            if( row[r] == n || col[c] == m ) return i;
        }
        return -1;
    }
}
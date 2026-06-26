class Solution {
    public long maxPoints(int[][] points) {
        int r = points.length, c = points[0].length;

        long [] arr = new long[c];
        for(int j=0; j<c; j++) arr[j] = points[r-1][j];
        
        for(int i = r-2; i>=0; i-- ){

            int n = c;
            long []suf = new long[n+1];
            suf[n] = -n;
            for(int j=n-1; j>=0; j--){
                suf[j] = Math.max(suf[j+1], arr[j]-j);
            }

            long pre = 0;
            long curr = 0 ;

            for( int j=0; j<n; j++ ){
                
                long temp = arr[j];

                curr = points[i][j] + arr[j];
                long left = points[i][j] - j + pre;
                long right = points[i][j] + j + suf[j+1];

                arr[j] = Math.max(curr, Math.max(left, right));

                pre = Math.max( pre , temp+j );

            }

        }

        long ans = 0;
        for(long e: arr) {
            ans = Math.max(ans, e);
            System.out.print(e+" ");
        }
        return ans;
    }
}
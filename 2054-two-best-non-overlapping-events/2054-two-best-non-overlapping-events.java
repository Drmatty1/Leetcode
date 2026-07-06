class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> a[0] - b[0] );

        int n = events.length;
        int []suf = new int[n];

        int [][]arr = new int[n][3];
        int singleMax = 0;
        for(int i=0; i<n; i++){
            arr[i] = new int[]{events[i][0],events[i][1],events[i][2]};
            singleMax = Math.max(singleMax, arr[i][2]);
        }
        Arrays.sort(arr, (a,b) -> a[1] - b[1] );


        suf[n-1] = events[n-1][2];
        for(int i=n-2; i>=0; i--) 
            suf[i] = Math.max(suf[i+1],events[i][2]);


        int max = 0;
        int res = 0;
        int j = 0;

        for(int i=0; i<n-1; i++){
            max = Math.max(max, arr[i][2]);
            int end = arr[i][1];
            while( j < n && events[j][0] <= end ) j++;
            if( j < n  ){
                res = Math.max(res, max+suf[j]);
            }
        }
        return Math.max(singleMax,res);
    }
}






























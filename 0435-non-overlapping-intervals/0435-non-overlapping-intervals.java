class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            if(a[0] == b[0]) return Integer.compare(b[1],a[1]);
            return Integer.compare(a[0],b[0]);
        });

        int i=1, n = intervals.length;
        int count =  0;

        int [][]it = intervals;
        int []prev = it[0];

        while(i<n){
            int a= it[i][0], b = it[i][1];
            if( b < prev[1] ){
                count++;
                prev = it[i];
            }
            else if( a < prev[1] ){
                count++;
                // prev remain same;
            }
            else{
                prev = it[i];
            }
            i++;
        }

        return count;

    }
}
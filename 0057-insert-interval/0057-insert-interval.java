class Solution {
    public int[][] merge(int[][] arr, int[] t) {
    
        int n = arr.length;
        if( n == 0 ) return new int[][]{t};

        int []prev = arr[0];
        List<int[]> res = new ArrayList<>();

        boolean flag = true;
        for( int i=0; i<n; i++ ){

            int []curr = arr[i];

            if( flag && curr[0] > t[0] ){
                if( i == 0 ){
                    prev = t;
                    curr = t;
                }
                else
                    curr = t;
                i--;
                flag = false;
            }
            if( prev[1] >= curr[0]  ){
                int s = prev[0], e = Math.max(prev[1],curr[1]);
                prev = new int[]{ s , e };
            }
            else{
                res.add(prev);
                prev = curr;
            }
        }
        
        if( flag ){
            if( prev[1] >= t[0] ){
                int s = prev[0], e = Math.max(prev[1],t[1]);
                prev = new int[]{ s , e };
                res.add(prev);
            }
            else{
                res.add(prev);
                res.add(t);
            }
        }
        else{
            res.add(prev);
        }
        

        return res.toArray(new int[res.size()][]);

    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        return merge(intervals, newInterval);
    }
}
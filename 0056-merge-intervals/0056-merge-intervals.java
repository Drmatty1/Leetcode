class Solution {
    public int[][] merge(int[][] intervals) {
        int [][]arr = intervals;
        Arrays.sort(arr,(a,b)->{
            if( a[0] != b[0] ) return a[0]-b[0];
            else return a[1]-b[1];
        });
        int n = arr.length;

        int []prev = arr[0];
        List<int[]> res = new ArrayList<>();

        for( int i=0; i<n; i++ ){
            int []curr = arr[i];
            if( prev[1] >= curr[0]  ){
                int s = prev[0], e = Math.max(prev[1],curr[1]);
                prev = new int[]{ s , e };
            }
            else{
                res.add(prev);
                prev = curr;
            }
        }
        res.add(prev);

        int l = res.size();
        int [][]ans = new int[l][2];
        for( int i=0; i<l; i++ ){
            ans[i] = res.get(i);
        }

        return ans;

    }
}









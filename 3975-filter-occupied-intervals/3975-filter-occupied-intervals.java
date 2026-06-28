class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
        
        int[][] arr = occupiedIntervals;
        Arrays.sort( arr,  (a,b) -> Integer.compare(a[1],b[1]) )  ;

        List<List<Integer>> res =  new ArrayList<>();

        Stack<int[]> s = new Stack<>();

        for(int i=0; i<arr.length; i++){
            int []curr = arr[i];

            while( !s.isEmpty() && curr[0] <= s.peek()[1] + 1 ){
                int prev[] = s.pop();
                curr = new int[]{ Math.min(prev[0],curr[0]), curr[1]};
            }

            s.add(curr);

        }

        while( !s.isEmpty() ) {

            int []prev = s.pop();
            int a = prev[0], b = prev[1];

            if( freeStart > b || freeEnd < a ){
                res.add(List.of(a, b));
            }
            else{
                if( freeEnd < b ) res.add(List.of( freeEnd+1, b));
                if( freeStart > a ) res.add(List.of(a, freeStart-1));
            }
            
        }

        Collections.reverse(res);
        return res;
    }
}
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
                prev = new int[]{ Math.min(prev[0],curr[0]), curr[1]};
                curr = prev;
            }

            s.add(curr);

        }

        while( !s.isEmpty() ) {

            int []prev = s.pop();

            if( freeStart > prev[1] || freeEnd < prev[0] ){
                res.add(List.of(prev[0],prev[1]));
            }
            else if( freeStart > prev[0] && freeEnd < prev[1] ){
                res.add(List.of(freeEnd+1,prev[1]));
                res.add(List.of(prev[0],freeStart-1));
            }
            else if( freeStart > prev[0] ){
                res.add(List.of(prev[0],freeStart-1));
            }
            else if( freeEnd < prev[1]  ){
                res.add(List.of(freeEnd+1,prev[1]));
            }

        }

        Collections.reverse(res);
        return res;
    }
}
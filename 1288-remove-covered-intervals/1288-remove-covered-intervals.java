class Solution {
    boolean contains(int[]a, int[]b){
        if(b[0] >= a[0] && b[1] <= a[1] )return true;
        return false;
    }
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            if(a[0] == b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });

        Stack<int[]> st = new Stack<>();
        for(int []i: intervals){
            if(!st.isEmpty() && contains(st.peek(), i)){
                // skiping i
            }
            else{
                st.add(i);
            }
        }
        return st.size();
    }
}
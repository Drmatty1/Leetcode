class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int []suf = new int[n];
        suf[n-1] = values[n-1]-(n-1);
        for(int i=n-2; i>=0; i--){
            suf[i] = Math.max(suf[i+1], values[i]-i);
        }
        
        int ans = 0;
        for(int i=0; i<n-1; i++){
            ans = Math.max(ans, i+values[i] + suf[i+1] );
        }
        return ans;
    }
}
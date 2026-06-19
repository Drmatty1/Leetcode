class Solution {
    public int largestAltitude(int[] gain) {
        int sum = 0, ans = 0;
        for(int e: gain){
            sum += e;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
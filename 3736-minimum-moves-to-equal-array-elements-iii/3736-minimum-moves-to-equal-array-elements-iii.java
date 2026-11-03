class Solution {
    public int minMoves(int[] nums) {
        int max = 0;
        for(int e: nums) if(e>max) max=e;

        int ans = 0;
        for(int e: nums) ans += max-e;
        return ans;
    }
}
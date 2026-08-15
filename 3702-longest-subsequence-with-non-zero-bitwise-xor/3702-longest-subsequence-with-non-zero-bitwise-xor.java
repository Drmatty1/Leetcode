class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int zeroCt = 0;
        int xor = 0;
        for(int e: nums){
            xor ^= e;
            if(e==0) zeroCt++;
        }
        if(zeroCt==n) return 0;
        if(xor!=0) return n;
        return n-1;
    }
}
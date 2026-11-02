class Solution {
    int Moves(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        int median = nums[nums.length/2];

        for(int e: nums) ans += Math.abs(e-median);
        return ans;
    }
    public int minMoves2(int[] nums) {
        return Moves(nums);
    }
}
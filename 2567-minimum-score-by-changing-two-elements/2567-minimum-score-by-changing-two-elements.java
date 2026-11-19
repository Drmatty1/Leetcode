class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int max = Math.min(nums[n-3]-nums[0],nums[n-1]-nums[2]);
        max = Math.min(max,nums[n-2]-nums[1]);
        return max;
    }
}
// 9 27 33 59 81
// 8 28 42 58 75
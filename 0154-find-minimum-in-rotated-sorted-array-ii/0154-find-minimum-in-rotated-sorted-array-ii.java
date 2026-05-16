class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        for(int e:nums) min = Math.min(min,e);
        return min;
    }
}
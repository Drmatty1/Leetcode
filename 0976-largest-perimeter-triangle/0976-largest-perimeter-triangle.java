class Solution {
    public int largestPerimeter(int[] nums) {
        int l = nums.length;
        Arrays.sort(nums);
        for( int i=l-3; i>=0; i-- ){
            if( nums[i]+nums[i+1] > nums[i+2] ){
                return nums[i]+nums[i+1]+nums[i+2];
            }
        }
        return 0;
    }
}
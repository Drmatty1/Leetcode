class Solution {
    public int minPatches(int[] nums, int n) {
        int count = 0;
        int len = nums.length;
        long r = 1;
        
        Arrays.sort(nums);
        int i=0;
        while( r-1 < n ){

            if( i < len && nums[i] <= r ){
                r += nums[i];
                i++;
            }
            else{
                r += r;
                count ++;
            }

        }

        return count;

    }
}
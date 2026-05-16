class Solution {
    public int findMin(int[] nums) {
        // int min = nums[0];
        // for(int e:nums) min = Math.min(min,e);
        // return min;

        // return Arrays.stream(nums).min().getAsInt();
        
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } 
            else if (nums[mid] < nums[high]) {
                high = mid;
            } 
            else {
                high--;
            }
        }

        return nums[low];
    
    }
}
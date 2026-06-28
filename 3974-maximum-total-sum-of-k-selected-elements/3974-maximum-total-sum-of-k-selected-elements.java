class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        long sum = 0;
        int n = nums.length;
        int j = n-1;
        while( k > 0 && mul > 0 ){
            sum += 1L*mul*nums[j];
            j--;
            mul--;
            k--;
        }

        while( k > 0 && nums[j] > 0 ){
            sum += nums[j];
            j--;
            mul--;
            k--;
        }
       
        int i = 0;
        while( k > 0 && i <= j ){
            sum += 1L*mul*nums[i];
            i++;
            mul--;
            k--;
        }

        return sum;
    }
}
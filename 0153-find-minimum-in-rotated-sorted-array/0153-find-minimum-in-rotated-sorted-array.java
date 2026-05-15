class Solution {

    public int findMin(int[] nums) {
        int n=nums.length;

        int i=0, j=n-1;
        while(i < j){
            int mid = (j-i)/2+i;
            if(nums[mid] > nums[i] && nums[mid] > nums[j]){
                i=mid+1;
            }
            else if(nums[mid]< nums[i] && nums[mid] <nums[j]){
                j = mid;
            }
            else{
                break;
            }
        }
        return nums[i]>nums[j]?nums[j]:nums[i];
    }
}
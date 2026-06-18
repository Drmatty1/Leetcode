class Solution {
    void swap(int []nums, int a, int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i=0, j = n-1, k = 0;
        while( k <= j ){
            if(nums[k] == 2 ){
                swap(nums, j, k);
                j--;
            }
            else if( nums[k] == 0 ){
                swap(nums, i, k);
                i++;
                k++;
            }
            else
                k++;
        }

        return ;
    }
}
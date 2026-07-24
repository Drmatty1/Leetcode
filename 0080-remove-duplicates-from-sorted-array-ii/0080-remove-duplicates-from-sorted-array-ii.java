class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0, j = 2, n = nums.length;
        int max = 100000;
        int temp = max;
        int count = 0;
        while(j<n){
            if(nums[j] == nums[i]) {
                count++;
                nums[j] = temp++;
                j++;
            }
            else{
                // if(i < 1) i++;
                // else i = j;
                i++;
                j = i+2;
            }
        }

        i = 0;
        j = 0;
        while(j<n){
            if(nums[j] < max){
                nums[i] = nums[j];
                i++;
                j++;
            }
            else{
                j++;
            }
        }

        return n-count;

    }
}
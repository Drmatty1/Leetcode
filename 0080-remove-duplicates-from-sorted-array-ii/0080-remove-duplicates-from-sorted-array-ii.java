class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0, j = 2, n = nums.length;
        int max = 100000;
        int temp = max;
        int count = 0;

        if(n <= 2 )return n;

        // if( nums[2] != nums[0] ){
        //     if(nums[1] != nums[0]){
        //         j = 1;
        //     }
        //     else j=2;
        // }

        while(j<n){
            if(nums[j] == nums[i]) {
                count++;
                nums[j] = temp++;
                j++;
            }
            else{
                
                // i++;
                i = j-1;
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
class Solution {
    void swap(int i, int j , int []a){
        int t= a[i];
        a[i]  = a[j];
        a[j] =t;
    }
    public int firstMissingPositive(int[] nums) {
        
        int n = nums.length;

        for(int i=0; i<n; i++){

            while(nums[i] > 0){
                if(nums[i] == i+1 ) break;
                if(nums[i] > n ) break;
                if(nums[i] == nums[nums[i]-1] ) break;
                swap(i,nums[i]-1,nums);
            }
        }

        for(int i=0; i<n; i++) if(nums[i] != i+1) return i+1;
        return n+1;

    }
}
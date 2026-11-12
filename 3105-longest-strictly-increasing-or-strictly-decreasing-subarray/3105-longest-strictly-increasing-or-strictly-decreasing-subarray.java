class Solution {
    int sol(int []nums){
        int n = nums.length;
        int max = 1;
        int count  =1;
        for(int i=1; i<n; i++ ){
            if(nums[i] > nums[i-1]){ 
                count++;
                max = Math.max(max, count);
            }
            else{
                count = 1;
            }
        }
        return max;
    }
    int sol1(int []nums){
        int n = nums.length;
        int max = 0;
        int count  =1;
        for(int i=1; i<n; i++ ){
            if(nums[i] < nums[i-1]){ 
                count++;
                max = Math.max(max, count);
            }
            else{
                count = 1;
            }
        }
        return max;
    }
    public int longestMonotonicSubarray(int[] nums) {
        
        return Math.max(sol(nums),sol1(nums));
    }
}
class Solution {
    public int sortPermutation(int[] nums) {
        int []arr = nums.clone();
        Arrays.sort(arr);
        int i=0;
        int ans=0;
        for( ; i<arr.length; i++ ){
            if(arr[i] != nums[i] ){
                ans = nums[i];
                break;
            }
        }
        for( ; i<arr.length; i++ ){
            if(arr[i] != nums[i] ){
                ans &= nums[i];
            }
        }
        return ans;
    }
}
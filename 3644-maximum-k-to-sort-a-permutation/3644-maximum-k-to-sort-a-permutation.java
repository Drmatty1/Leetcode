class Solution {
    int solve1(int[]nums){
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
    void swap(int[]arr,int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    int solve2(int []nums){
        int ans = (1<<29)-1;
        int i=0, n =  nums.length;
        while( i<n ){
            while( nums[i] != nums[nums[i]] ){
                ans &= nums[i];
                ans &= nums[nums[i]];
                swap(nums,nums[i],i);
            }
           i++;
        }
        return ans;
    }
    public int sortPermutation(int[] nums) {
        int ans = solve2(nums);
        return ans==((1<<29)-1)?0:ans;
    }
}
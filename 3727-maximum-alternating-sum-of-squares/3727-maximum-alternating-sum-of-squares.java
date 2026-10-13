class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        for(int i=0; i<n; i++){
            nums[i] *= nums[i];
        }

        Arrays.sort(nums);
        int i=0,j=n-1;
        long ans = 0;

        while(i<=j){
            ans += nums[j--];
            if(i<=j) ans-=nums[i++];
        }

        return ans;
    }
}
// 1 1 4 4 9 9
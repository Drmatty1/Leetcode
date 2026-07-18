class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n =  nums.length;
        int []ans = new int[n];
        Arrays.fill(ans,1);

        // 1st pass left - right , ans[i] = prod[0..i-1];
        int prod = nums[0];
        for(int i=1; i<n; i++){
            ans[i] = prod;
            prod *= nums[i];
        }

        // 2nd pass
        prod = nums[n-1];
        for(int j=n-2; j>=0; j--){
            ans[j] *= prod;
            prod *= nums[j];
        }

        return ans;
    }
}











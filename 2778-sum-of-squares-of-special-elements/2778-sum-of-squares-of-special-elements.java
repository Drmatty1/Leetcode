class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length, ans= 0 ;
        for(int i=1; i<=n; i++) 
            ans += ((n%i==0)?(nums[i-1]*nums[i-1]):0);
        return ans;
    }
}
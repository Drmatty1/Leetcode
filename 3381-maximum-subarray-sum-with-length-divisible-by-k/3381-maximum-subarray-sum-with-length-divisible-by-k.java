class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long []pre = new long[n+1];
        Arrays.fill(pre,Long.MAX_VALUE>>1);
        pre[0] = 0;
        long sum = 0;
        long ans = Long.MIN_VALUE;

        for(int i=1; i<=n; i++){
            sum += nums[i-1];
            // if(i>=k)
                ans = Math.max(ans,sum-pre[i%k]);
            pre[i%k] = Math.min(pre[i%k],sum);
            // System.out.println(pre[i%k]);
        }
        return ans;
    }
}
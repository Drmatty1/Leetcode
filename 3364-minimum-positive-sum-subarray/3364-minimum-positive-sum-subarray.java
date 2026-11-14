class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int []pre = new int[n+1];
        for(int i=0; i<n; i++){
            pre[i+1] = pre[i]+nums.get(i);
        }

        int minSum = n*10000;
        for(int len = l; len <= r; len++){
            for(int i=0; i<=n-len; i++){
                int sum = pre[i+len]-pre[i];
                if(sum>0) minSum = Math.min(minSum,sum);
            }
        }

        return minSum==n*10000?(-1):minSum;
    }
}
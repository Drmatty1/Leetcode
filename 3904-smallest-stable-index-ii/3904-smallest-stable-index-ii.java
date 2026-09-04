class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int []suff = new int[n+1];
        suff[n] = Integer.MAX_VALUE;
        for(int i=n-1; i>=0; i--){
            suff[i] = Math.min(suff[i+1],nums[i]);
        }

        int pre =  0;
        for(int i=0; i<n; i++){
            pre = Math.max(pre,nums[i]);
            if( pre - suff[i] <= k ) return i;
        }

        return -1;
    }
}
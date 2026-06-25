class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int []pre = new int[n+1];
        for(int i=0; i<n; i++){
            pre[i+1] = pre[i] + (target==nums[i]?1:0);
        }
        int ans = 0; 
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int len = j-i+1;
                int freq = pre[j+1]-pre[i];
                if( freq*2 > len ) ans ++;
            }
        }
        return ans;
    }
}
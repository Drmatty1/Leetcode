class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;

        for(int i = n-1; i>=0; i--){

            if(nums1[i] > nums2[i]){
                int temp = nums1[i];
                nums1[i] = nums2[i];
                nums2[i] = temp;
            }
        }

        int []dp1 = new int[n];
        int []dp2 = new int[n];
        dp1[n-1] = 1;
        dp2[n-1] = 1;
        int ans = 1;
        for(int i=n-2; i>=0; i--){

            if(nums1[i] <= nums1[i+1]) dp1[i] = 1+dp1[i+1];
            else if( nums1[i] <= nums2[i+1] ) dp1[i] = 1+dp2[i+1];
            else dp1[i] = 1;

            if(nums2[i] <= nums1[i+1]) dp2[i] = 1+dp1[i+1];
            else if( nums2[i] <= nums2[i+1] ) dp2[i] = 1+dp2[i+1];
            else dp2[i] = 1;

            ans = Math.max(ans,Math.max(dp1[i],dp2[i]));

        }

       
        return ans;
    }
}
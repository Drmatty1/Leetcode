class Solution {
    int BS(int []arr, int s, int e, int t){
        int ps=-1;
        int mid;
        while(s<=e){
            mid = (e-s)/2+s; 
            if( arr[mid] >= t ){
                ps = mid;
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return ps;
    }
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0;
        int n1 = nums1.length, n2 = nums2.length;
        int e = n2-1;
        for(int i=n1-1; i>=0; i--){
            int idx = BS(nums2,i,e,nums1[i]);
            if( idx != -1 ){
                ans = Math.max(ans,idx-i);
                e=idx;
            }
        }
        return ans;
    }
}
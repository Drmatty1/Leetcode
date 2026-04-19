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
    int sol1(int []nums1, int[] nums2){
        int ans = 0;
        int n1 = nums1.length, n2 = nums2.length;
        int e = n2-1;
        for(int i=n1-1; i>=0; i--){
            int idx = BS(nums2,i,e,nums1[i]);
            if( idx != -1 ){
                ans = Math.max(ans,idx-i);
                e=idx;   // pruning
            }
        }
        return ans;
    }
    int sol2(int []nums1, int[] nums2){
        int ans = 0;
        int n1 = nums1.length, n2 = nums2.length;
        int s=0;
        for( int i=0; i<n1; i++ ){
            while( s<n2 && nums2[s]>=nums1[i])s++;
            if( s<=n2 && s>0 && s>i ){
                ans = Math.max(ans,s-i-1);
            }
        }
        return ans;
    }
    public int maxDistance(int[] nums1, int[] nums2) {
       return sol2(nums1,nums2);
    }
}
class Solution {
    int sol(int[] nums) {
        int n = nums.length;

        int []suf = new int[n+1];
        for(int i=n-1; i>=0; i-- ){
            if(nums[i] == 0) continue;
            else{
                suf[i] = 1+suf[i+1] ;
            }
        }

        int ans = 0;
        int pref = 0;
        for(int i=0; i<n; i++){
            int curr = nums[i];
            ans = Math.max(pref+suf[i+1], ans);
            
            if(curr == 0) pref = 0;
            else pref++;
        }

        return ans;

    }
    public int longestSubarray(int[] nums) {
        int n = nums.length;

        int zeroDel = 0;
        int oneDel = 0;

        int ans = 0;

        for(int i=0; i<n; i++){
            int curr = nums[i];

            if(i > 0)
                oneDel = Math.max( 
                    ((curr==0)?0:(1+oneDel)) ,
                    zeroDel
                );

            if(curr == 0 ) zeroDel=0;
            else zeroDel++;

            ans = Math.max(ans, oneDel);
        }

        return ans;

    }
}
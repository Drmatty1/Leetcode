class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        int[]suf = new int[n+1];
        for(int i=n-1; i>=0; i--){
            suf[i] += suf[i+1]+nums[i];
        }

        int []pre = new int[n+1];
        for(int i=0; i<n; i++){
            pre[i+1] = pre[i]+nums[i];
        }

        int j = n;
        while(j>=0 && suf[j] <= x) j--;
        j++;

        if (suf[0] == x) {
            return n;
        }

        int i=0;
        int ans = 2*n;

        while( i < j && j <= n){
            if(suf[j]+pre[i] == x){
                ans = Math.min(ans, i+(n-j));
                // System.out.println(ans+" "+i+" "+j);
            }

            i++;
            while(j<=n && suf[j]+pre[i] > x) j++;
        }

        return ans==(2*n)?(-1):ans;
    }
}
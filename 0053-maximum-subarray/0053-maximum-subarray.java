class Solution {
    int solve(int[] nums, int s, int e){
        
        if(s>e) return -10000;
        int mid = (e-s)/2+s;
        
        int op1 = solve(nums,s,mid-1);
        int op2 = solve(nums, mid+1, e);
        
        int sum = 0;
        int lmax = -10000;
        for( int i=mid-1; i>=s; i-- ){
            sum += nums[i];
            lmax = Math.max(lmax,sum);
        }

        sum = 0;
        int rmax = -10000;
        for( int i=mid+1; i<=e; i++ ){
            sum += nums[i];
            rmax = Math.max(rmax,sum);
        }
        int c = nums[mid];
        int currmax = Math.max(c+lmax+rmax,Math.max(lmax+c,rmax+c));
        currmax = Math.max(currmax, c);
        return Math.max(currmax,Math.max(op1,op2));
        
    }
    public int maxSubArray(int[] nums) {
        return solve(nums,0,nums.length-1);
    }
}
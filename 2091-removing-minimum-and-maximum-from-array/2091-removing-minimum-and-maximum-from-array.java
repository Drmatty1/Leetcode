class Solution {
    public int minimumDeletions(int[] nums) {
        int max = -100000, min = 100000, n = nums.length;
        int maxidx=0, minidx=0;
        for( int i = 0; i<n; i++ ){
            if( nums[i] > max ){ 
                maxidx=i;
                max = nums[i];
            }
            if( nums[i] < min ){ 
                minidx=i;
                min = nums[i];
            }
        }
        
        if( maxidx < minidx ){ 
            int temp = maxidx;
            maxidx = minidx;
            minidx = temp;
        }
        int op1 = n - (maxidx-minidx-1) ;
        int op2 = maxidx+1;
        int op3 = n - minidx;
        return Math.min(op1,Math.min(op2,op3));
    }
}
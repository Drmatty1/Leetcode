class Solution {
    int findmax(int[]arr, int e){
        int max = -1;
        for( int i=0; i<=e; i++ ) 
            max = Math.max(max,arr[i]);
        return max;
    }
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        if( n == 1 ){
            return (k%2)==0?nums[0]:(-1);
        }
        if( k < n ){
            int op1 = findmax(nums,k-2);
            int op2 = nums[k];
            return Math.max(op1,op2);
        }
        else if( k==n ){
            return findmax(nums,n-2);
        }
        else{
            return findmax(nums,n-1);
        }
    }
}
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int []p = new int[n];
        int []s = new int[n];
        p[0] = nums[0];
        s[n-1] = nums[n-1];
        for( int i=1; i<n; i++ ){
            p[i] = p[i-1]+nums[i];
            s[n-i-1] = s[n-i]+nums[n-i-1];
        }

        for(int e:p)System.out.print(e+" ");
        System.out.println();

        for( int i=0; i<n; i++ ){
            int a = i, b = n-i-1;
            int l = i==0?0:p[i-1];
            int r = (i==n-1)?0:s[i+1];
            nums[i] = a*nums[i]-l + r-b*nums[i];
        }
        return nums;
    }
}
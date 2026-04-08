class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int M = 1000000007;
        for( int[] q : queries ){
            int idx = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];
            while( idx <= r ){
                nums[idx] = (int)((1l*nums[idx]*v)%(M));
                idx += k;
            }
        }
        int ans = 0;
        for( int e : nums ) ans ^= e;
        return ans;
    }
}
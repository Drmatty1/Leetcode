class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int max = nums.length;
        if(max <= 2 ) return max;
        int log = 31 - Integer.numberOfLeadingZeros(max);
        return 1<<(log+1);
    }
}
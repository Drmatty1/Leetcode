class Solution {
    int ds(int e){
        int c=0;
        while(e>0){
            c += e%10;
            e /= 10;
        }
        return c;
    }
    public int smallestIndex(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(ds(nums[i]) == i)return i;
        }
        return -1;
    }
}
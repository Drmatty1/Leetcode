class Solution {
    int hcf(int a, int b){
        if(b==0)return a;
        return hcf(b,a%b);
    }
    public int minOperations(int[] nums, int[] numsDivide) {
        int hcfAll=0;
        for(int e: numsDivide) hcfAll = hcf(hcfAll,e);
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length){
            if( hcfAll%nums[i]==0 ){
                return i;
            }
            i++;
        }
        return -1;
    }
}
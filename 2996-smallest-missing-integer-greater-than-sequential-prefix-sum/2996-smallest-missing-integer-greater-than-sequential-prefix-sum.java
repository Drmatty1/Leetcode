class Solution {
    public int missingInteger(int[] nums) {

        int sum = 0;
        int min = 0;

        for(int i=0; i<nums.length; i++){
            if( i==0 || nums[i] == nums[i-1]+1 ){
                sum += nums[i];
            }
            else{
                break;
            }
            min = sum;
        }

        int []freq = new int[51];
        for(int e: nums) freq[e]++;

        while(min<=50 && freq[min]>0) min++;

        return min;
    }
}
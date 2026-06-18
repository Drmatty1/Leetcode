class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        int sum = 0;
        int prevSum = 0;
        // set.add(0);

        for(int i=0; i<nums.length; i++){
            int e = nums[i];
            sum += e;

            if(i-2 >= -1){
                prevSum += (i==1?0:nums[i-2]);
                set.add(prevSum%k);
            }

            if(set.contains(sum%k)) return true;
        }

        return false;
    }
}
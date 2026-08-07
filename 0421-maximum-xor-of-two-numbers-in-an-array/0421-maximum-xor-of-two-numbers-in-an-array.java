class Solution {
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        int max = 0, mask=0;

        // here we are tring to maximize i'th bit 
        for(int i=30; i>=0; i--){
            
            mask = mask | (1<<i);
            Set<Integer> set = new HashSet<>();
            for(int num: nums){
                set.add(num & mask);
            }

            // ideal candidate (pref) we want to get
            int cand = max | (1<<i);
            // here we want to check prefx^prefy == cand -> o(n^2)
            // instead use property a^b = c  -> a^c = b;
            for(int pref: set){
                if(set.contains(pref^cand)){
                    max = cand;
                    break;
                }
            }
        }

        return max;
    }
}
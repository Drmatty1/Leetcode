class Solution {
    public int missingMultiple(int[] nums, int k) {
        int m = k;
        while(true){
            boolean found = false;
            for(int e: nums){
                if(e == m){
                    found = true;
                    break;
                }
            }
            if(found==false) return m;
            m += k; 
        }
    }
}
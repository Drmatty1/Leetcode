class Solution {
    int MAX = Integer.MAX_VALUE;
    public boolean uniformArray(int[] nums1) {
        int minOdd = MAX, minEven = MAX;

        for(int e: nums1) {
            if(e%2==0){
                minEven = Math.min(minEven,e);
            }else{
                minOdd = Math.min(minOdd,e);
            }
        }

        if(minOdd == MAX || minEven == MAX) return true;
        
        return minEven > minOdd;
    }
}















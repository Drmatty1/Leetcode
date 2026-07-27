class Solution {
    public int maxProduct(int[] nums) {
        int m1 = 1, m2 =1;
        for(int e: nums){
            if(m1<m2){
                m1 = Math.max(m1,e);
            }
            else{
                m2 = Math.max(m2,e);
            }
        }
        return (m1-1)*(m2-1);
    }
}
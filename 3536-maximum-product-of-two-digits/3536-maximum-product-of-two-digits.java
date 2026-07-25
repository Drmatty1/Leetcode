class Solution {
    public int maxProduct(int n) {
        int m1 = -1, m2 = -1;
        while(n>0){
            if(m1 < m2){
                m1 = Math.max(m1,n%10);
            }
            else{
                m2 = Math.max(m2,n%10);
            }
            n /= 10;
        }
        return m1*m2;
    }
}
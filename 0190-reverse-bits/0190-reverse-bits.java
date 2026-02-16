class Solution {
    
    public int reverseBits(int n) {
        
        int ans= 0 ,power = 31;
        while( power >= 0 ){
            ans |= (n%2)<<power;
            n = n>>1;
            power--;
        }
        return ans;
    }
}
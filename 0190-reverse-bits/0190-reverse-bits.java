class Solution {
    public int reverseBits(int n) {
        StringBuilder ans = new StringBuilder();
        while( ans.length() < 32 ){
            int rem = n%2;
            ans.append((char)(rem+'0'));
            n = n/2;
        }
        
        return Integer.parseInt(ans.toString(),2);
    }
}
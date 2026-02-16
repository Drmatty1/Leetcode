class Solution {
    public int reverseBits(int n) {
        StringBuilder ans = new StringBuilder();
        while( n != 0 ){
            int rem = n%2;
            ans.append((char)(rem+'0'));
            n = n/2;
        }
        while( ans.length() < 32 ) ans.append('0');
        return Integer.parseInt(ans.toString(),2);
    }
}
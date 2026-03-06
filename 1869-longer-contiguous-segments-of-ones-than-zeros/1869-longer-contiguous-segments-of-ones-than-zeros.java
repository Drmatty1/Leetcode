class Solution {
    public boolean checkZeroOnes(String s) {
        int one = 0, zero=0, l=s.length(), i=0;
        while ( i<l ){
            if( s.charAt(i) == '1' ){
                int temp=0;
                while( i<l && s.charAt(i) == '1'){
                    i++; temp++;
                }
                one = Math.max(one,temp);
            }
            else{
                int temp=0;
                while( i<l && s.charAt(i) == '0'){
                    i++; temp++;
                }
                zero = Math.max(zero,temp);
            }
        }
        return one>zero;
    }
}
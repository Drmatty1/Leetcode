class Solution {
    public boolean checkOnesSegment(String s) {
        int l = s.length() , count = 0 ;
        int i = 0;
      
        while ( i<l ){
            if( s.charAt(i) == '1' ){
                count++;
                while( i<l && s.charAt(i) == '1') i++;
            }
            else i++;
        }
        return count<2;
    }
}
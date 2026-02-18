class Solution {
    public String largestPalindromic(String num) {
        
        int []no = new int[10];
        for( char c : num.toCharArray() ) no[c-'0']++;

        StringBuilder ans = new StringBuilder();
        
        for( int i = 9; i>=0; i-- ){
            int count  = no[i]/2;
            if( i == 0 && ans.length()==0 ) break;
            while( count-->0 )ans.append( (char)(i+'0') );
        }
        int flag = 0;
        for( int i = 9; i>=0; i-- ){
            if( no[i] % 2 != 0 ){
                if( i == 0 && ans.length()==0 ) break;
                ans.append((char)(i+'0'));
                flag = 1;
                break;
            }
        }
        int l = ans.length()-flag;
        for( int i=l-1; i>=0; i-- ) ans.append(ans.charAt(i));
        if( ans.length() == 0 ) return "0";
        return new String(ans);
    }
}
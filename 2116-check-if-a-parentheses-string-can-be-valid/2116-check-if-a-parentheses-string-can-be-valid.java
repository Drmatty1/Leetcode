class Solution {
    public boolean canBeValid(String s, String locked) {
        
        int open = 0, close = 0, l = s.length();
        if( (l&1) == 1 ) return false;

        for( int i=0; i<l; i++ ){
            char c = s.charAt(i), L = locked.charAt(i);
            if( c == ')' && L == '1' ) close++;
            else open++;
            if( close > open ) return false;
        }
        open = 0; close = 0;
        for( int i=l-1; i>=0; i-- ){
            char c = s.charAt(i), L = locked.charAt(i);
            if( c == '(' && L == '1' ) open++;
            else close++;
            if( close < open ) return false;
        }
        return true;
    }
}
class Solution {
    public String minRemoveToMakeValid(String s) {

        StringBuilder ans = new StringBuilder();
        int open = 0, close=0, size = s.length();

        for( int i=0; i<size; i++ ){

            char c = s.charAt(i);

            if( c == '(' ){
                open++;
                ans.append(c);
            }
            else if( c == ')'  ){
                if( open > close ){
                    close++;
                    ans.append(c);
                }
            }
            else ans.append(c);
        }
        
        if( close == open ) return ans.toString();
        
        open = 0; close = 0;
        StringBuilder res = new StringBuilder();
        int l=ans.length();

        for( int i=l-1; i>=0; i-- ){
            
            char c = ans.charAt(i);
            if( c == ')' ){
                close++;
                res.append(c);
            }
            else if( c == '('  ){
                if( open < close ){
                    open++;
                    res.append(c);
                }
            }
            else res.append(c);
        }

        return res.reverse().toString();
    }
}
class Solution {
    public String minRemoveToMakeValid(String s) {

        // StringBuilder ans = new StringBuilder();
        int size = s.length();
        char []ans = new char[size];
        int top=0;
        int open = 0, close=0;
        
        for( char c : s.toCharArray() ){
            if( c == '(' ){
                open++;
                ans[top++] = c;
            }
            else if( c == ')'  ){
                if( open > close ){
                    close++;
                    ans[top++] = c;
                }
            }
            else ans[top++] = c;
        }
        
        if( close == open ) return new String(ans,0,top);
        
        open = 0; close = 0;
        // StringBuilder res = new StringBuilder();
        // int l=ans.length();
        char []res = new char[top];
        int i = top-1;
        int j=i;
        for( ; j>=0; j-- ){
            char c = ans[j];
            if( c == ')' ){
                close++;
                res[i--] = c;
            }
            else if( c == '('  ){
                if( open < close ){
                    open++;
                    res[i--] = c;
                }
            }
            else res[i--] = c;
        }
       
        return new String(res,i+1,top-i-1);

    }
}
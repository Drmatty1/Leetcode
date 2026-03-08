class Solution {
    String solve( String s ){
        StringBuilder ans = new StringBuilder();
        int open = 0, close=0;
        for( char c : s.toCharArray() ){
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
    String solve2( String s ){
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
        char []res = new char[top];
        int i = top-1;

        for( int j=i; j>=0; j-- ){
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
    public String minRemoveToMakeValid(String s) {
        return solve2(s);
    }
}
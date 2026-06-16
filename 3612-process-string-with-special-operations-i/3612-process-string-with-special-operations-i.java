class Solution {
    public String processStr(String s) {
        StringBuilder res = new StringBuilder();
        for(char c: s.toCharArray()){
            if( c == '*' ){
                if( res.length()!=0 ){
                    res.setLength(res.length()-1);
                }
            }
            else if( c == '#' ){
                if( res.length()!=0 ){
                    res.append(res);
                }
            }
            else if( c == '%' ){
                if( res.length()!=0 ){
                    res = res.reverse();
                }
            }
            else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
class Solution {
    public String addBinary(String a, String b) {
        if( a.equals("0")  ) return b;
        if ( b.equals("0") )  return a;

        StringBuilder ans = new StringBuilder();
        int l = a.length(), m = b.length();
        int i = l-1, j = m-1;
        char carry = '0';
        while( i>=0 && j>= 0 ){
            char p = a.charAt(i), q = b.charAt(j);
            if( p == '1' && q == '1' ){
                if( carry == '1' ){
                    ans.append("1");
                }
                else{
                    ans.append("0");
                    carry = '1';
                }
            }
            else if( (p == '1' && q == '0') || (p == '0' && q == '1')){
                if( carry == '1' ){
                    ans.append("0");
                }
                else{
                    ans.append("1");
                    carry = '0';
                } 
            }
            else{
                if( carry == '1' ){
                    ans.append("1");
                    carry = '0';
                }
                else{
                    ans.append("0");
                }
            }
            i--;
            j--;
        }
        while( i>=0 ){
            char p = a.charAt(i);
            i--;
            if( carry == '0' ){
                ans.append(p);
            }
            else if( p == '1'){
               ans.append("0");
            }
            else{
                ans.append("1");
                carry = '0';
            }
        }
        while( j>=0 ){
            char q = b.charAt(j);
            j--;
            if( carry == '0' ){
                ans.append(q);
            }
            else if( q == '1'){
               ans.append("0");
            }
            else{
                ans.append("1");
                carry = '0';
            }
        }
        if( carry == '1' ) ans.append(carry);

        return ans.reverse().toString();

    }
}
class Solution {
    public String addBinary(String a, String b) {
    
        StringBuilder ans = new StringBuilder();
        int i = a.length()-1, j = b.length()-1;
        int carry = 0;

        while( i>=0 || j>= 0 || carry==1 ){
            
            int p = i>=0 ? (a.charAt(i)-'0'):0;
            int q = j>=0 ? (b.charAt(j)-'0'):0;
            int sum = (p+q+carry)%2;
            carry = (p+q+carry)/2;
            ans.append((char)(sum+'0'));
            i--;
            j--;
        }
        return ans.reverse().toString();
    }
}

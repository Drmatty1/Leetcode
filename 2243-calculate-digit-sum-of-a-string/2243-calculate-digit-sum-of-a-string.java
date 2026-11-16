class Solution {
    String sol(String s, int k) {
        int l = k;
        StringBuilder res = new StringBuilder();
        int temp = 0;
        int i=0;
        while(k-->0 && i<s.length()){
            temp += s.charAt(i++)-'0';
            if(k==0 || i==s.length()){
                res.append(Integer.toString(temp));
                temp = 0;
                k = l;
            }
        }
        return new String(res);
    }
    public String digitSum(String s, int k) {
        while(s.length() > k) s = sol(s,k);
        return s;
    }
}
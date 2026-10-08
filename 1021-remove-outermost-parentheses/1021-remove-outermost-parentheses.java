class Solution {

    String sol(String s) {
        int i=0,j=0;
        StringBuilder ans = new StringBuilder();
        int n = s.length();

        int bal=0;
        while(j<n){
            
            char c = s.charAt(j);
            if(c=='(') bal++;
            else bal--;

            if(bal==0){
                ans.append(s.substring(i+1,j));
                j++;
                i=j;
            }
            else{
                j++;
            }
        }
        return ans.toString();
    }

    String solOP(String s) {

        int j=0;
        StringBuilder ans = new StringBuilder();
        int n = s.length();

        int bal=0;
        while(j<n){
            
            char c = s.charAt(j);

            if(c=='(') bal++;
            else bal--;

            if((bal!=1 && c=='(') || (bal!=0 && c==')')) 
                ans.append(c);
            j++;
        }
        return ans.toString();
    }
    public String removeOuterParentheses(String s) {
        return solOP(s);
    }
}
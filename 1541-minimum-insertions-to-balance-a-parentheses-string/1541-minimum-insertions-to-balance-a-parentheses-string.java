class Solution {
    public int minInsertions(String s) {
        int bal=0, j=0, n=s.length();
        int ans = 0;
        while(j<n){
            char c =s.charAt(j);

            if(c=='(') bal+=2;
            else bal -= 1;


            if((bal&1) == 1 && (j<n-1 && s.charAt(j+1)=='(')){
                ans += 1;
                bal -= 1;
            }
            
            if(bal<0){
                if(bal==-1 && j<n-1 && s.charAt(j+1)==')'){
                    j++;
                    continue;
                }
                bal *= -1;
                if(bal%2==0) ans += bal/2;
                else ans += bal/2 + 2;
                bal = 0;
            }

            j++;
        }

        ans += bal;
        return ans;
    }
}
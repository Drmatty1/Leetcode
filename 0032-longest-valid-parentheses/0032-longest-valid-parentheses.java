class Solution {
    int sol1(String s) {
        int i=0,j=0,n=s.length();
        char []arr = s.toCharArray();
        int bal = 0;
        int ans = 0;
        while(j < n){
            int val = (arr[j]=='('?1:(-1));
            bal += val;
            // System.out.println(bal+" "+j);
            if(bal < 0){
                bal = 0;
                i = j+1;
                j = j+1;
            }
            else{
                if(bal == 0) ans = Math.max(ans,j-i+1);
                j = j+1;
            }
        }
        return ans;
    }

    int sol2(String s) {
        int n=s.length();
        char []arr = s.toCharArray();
        int bal = 0;
        int ans = 0;
        int i=n-1,j=n-1;
        while(j >=0 ){
            int val = (arr[j]==')'?1:(-1));
            bal += val;
            // System.out.println(bal+" "+j);
            if(bal < 0){
                bal = 0;
                i = j-1;
                j = j-1;
            }
            else{
                if(bal == 0) ans = Math.max(ans,i-j+1);
                j = j-1;
            }
        }
        return ans;
    }
    public int longestValidParentheses(String s) {
        return Math.max(sol1(s),sol2(s));
    }
}

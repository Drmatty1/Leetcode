class Solution {
    //dp soln
    boolean sol(String s, int i, int open){

        if(i>=s.length()) return open==0;

        boolean res = false;
        char curr = s.charAt(i);

        if(curr == '*'){
            // * -> (
            res |= sol(s,i+1,open+1);

            // * -> ) 
            if(open>0) res |= sol(s,i+1,open-1);

            // * -> ""
            res |= sol(s,i+1,open);

        }
        else{
            if(curr == ')')  res |= sol(s,i+1,open-1);
            else res |= sol(s,i+1,open+1);
        }

        return res;
        
    }
    boolean sol1(String s, int i, int open, Boolean [][]dp){
        if(open < 0) return false;
        if(i>=s.length()) return open==0;

        if(dp[i][open] != null) return dp[i][open];

        boolean res = false;
        char curr = s.charAt(i);

        if(curr == '*'){
            // * -> (
            res |= sol1(s,i+1,open+1,dp);

            // * -> ) 
            if(open>0) res |= sol1(s,i+1,open-1,dp);

            // * -> ""
            res |= sol1(s,i+1,open,dp);

        }
        else{
            if(curr == ')')  res |= sol1(s,i+1,open-1,dp);
            else res |= sol1(s,i+1,open+1,dp);
        }

        return dp[i][open] = res;
    }

    // 2stack soln
    boolean sol2(String s){
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='(') open.push(i);
            else if(c=='*') star.push(i);
            else {
                if(!open.isEmpty()) open.pop();
                else if(!star.isEmpty()) star.pop();
                else{
                    return false;
                }
            }
        }

        while(!open.isEmpty()){
            int i = open.pop();
            if(!star.isEmpty() && i < star.peek()){
                star.pop();
            }
            else return false;
        }

        return true;
        
    }

    public boolean checkValidString(String s) {
        // return sol(s,0,0);

        // int n = s.length();
        // Boolean [][]dp = new Boolean[n][n+1];
        // return sol1(s,0,0,dp);

        return sol2(s);
    }
}
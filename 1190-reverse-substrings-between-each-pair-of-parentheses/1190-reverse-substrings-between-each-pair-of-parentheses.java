class Solution {
    public String reverseParentheses(String s) {
        // Stack<String> st = new Stack<>();
        Deque<StringBuilder> st = new ArrayDeque<>();

        int n = s.length();
        StringBuilder res = new StringBuilder();

        for(int i=0; i<n ;i++){
            char c = s.charAt(i);

            if(c == '('){
                st.addLast(res);
                res = new StringBuilder();
            }
            else if( c == ')'){
                StringBuilder t = new StringBuilder("");
                if(!st.isEmpty()) t = st.pollLast();
                res = t.append(res.reverse());
            }
            else{
                res.append(c);
            }
        }

        return new String(res);
    }
}
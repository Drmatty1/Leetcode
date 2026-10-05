class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();

        for(char c : s.toCharArray()){

            if(c=='('){
                st.push(-1);
            }
            else{
                if(st.peek() == -1){
                    st.pop();
                    st.add(1);
                }
                else{
                    int sum=0;
                    while(st.peek() != -1) sum+=st.pop();
                    sum = sum*2;
                    st.pop();
                    st.add(sum);
                }
            }
        }

        int sum=0;
        while(!st.isEmpty() && st.peek() != -1) sum+=st.pop();
        st.add(sum);
        return st.peek();
    }
}
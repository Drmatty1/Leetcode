class Solution {
    public int calculate(String s) {
        // s = s.replace(" ", "");
        Stack<Integer> st = new Stack<>();
        char sign = '+';
        int num = 0;
        int n = s.length();

        for(int i=0; i<=n; i++){
            char c = (i<n)?s.charAt(i):'Q';

            if(c == ' ') continue;

            if( i < n && c<='9' && c >= '0' ){
                num = num*10 + (c-'0');
            }
            else{
                switch (sign){
                    case '+' : st.push(num); break;
                    case '-' : st.push(-num); break;
                    case '*' : st.push(st.pop()*num); break;
                    case '/' : st.push(st.pop()/num); break;
                }
                
                sign = c;
                num = 0;
            }
        }

        int sum = 0;
        while (!st.isEmpty()) sum += st.pop();
        return sum;
    }
}
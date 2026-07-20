class StockSpanner {
    Stack<int[]> st;
    public StockSpanner() {
        st  = new Stack<>();
    }
    
    public int next(int price) {
        int count = 1;
        // st.peek()[0] -> last elem, ..[1]->span
        while(!st.isEmpty() && price >= st.peek()[0]){
            count += st.pop()[1];
        }
        st.add(new int[]{price,count});
        return st.peek()[1];
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder res = new StringBuilder();
        while(num-->0){
            int v = Math.min(sum,9);
            sum -= v;
            res.append((char)(v+'0'));
        }
        
        if(sum>0) return "";
        return res.toString();
    }
}
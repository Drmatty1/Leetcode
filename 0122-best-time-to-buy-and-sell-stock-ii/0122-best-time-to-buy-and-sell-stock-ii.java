class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        int n = prices.length;
        for(int i=n-1; i>0; i--){
            int temp = (prices[i]-prices[i-1]);
            if(temp>0 ) sum += temp;
        }
        return sum;
    }
}
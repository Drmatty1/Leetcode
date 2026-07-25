class Solution {

    // Max Optimized
    int sol1(int[] prices) {
       int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;

        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }

        return sell2;
    }

    int sol2(int[] prices) {
        int cs = 0;
        int n = prices.length;

        int []suf = new int[n+1];
        for(int i=n-1; i>=0; i--) suf[i] = Math.max(suf[i+1],prices[i]);

        int []res = new int[n];
        for(int i=0; i<n; i++){
            int max = suf[i+1];
            int curr = prices[i];
            if(max > curr) res[i] = max-curr;
        }

        int []suf_res = new int[n+1];
        suf_res[n-1] = res[n-1];
        for(int i=n-2; i>=0; i--){
            suf_res[i] = Math.max(suf_res[i+1],res[i]);
        }


        int ans = 0;

        int min = prices[0];
        for(int i=1; i<n; i++){
            int left = prices[i]-min;
            int right = suf_res[i+1];
            ans = Math.max(ans,left+right);

            min = Math.min(min,prices[i]);
        }

        return ans;
    }

    public int maxProfit(int[] prices) {
       return sol2(prices);
    }
}
//3 5 7
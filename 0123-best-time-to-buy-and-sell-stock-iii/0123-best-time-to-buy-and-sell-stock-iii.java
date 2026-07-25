class Solution {

    // Max Optimized
    int sol0(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        // Initializing the wallets for Day 1
        int buy1 = -prices[0];       // Spent money to buy the 1st stock
        int sell1 = 0;               // No profit yet
        int buy2 = Integer.MIN_VALUE; // Haven't started the 2nd transaction yet
        int sell2 = 0;               // No final profit yet

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];

            // 1. Maximize cash after buying 1st stock (cheapest price)
            buy1 = Math.max(buy1, -price);

            // 2. Maximize profit after selling 1st stock
            sell1 = Math.max(sell1, buy1 + price);

            // 3. Maximize cash after buying 2nd stock (reinvesting sell1 profit)
            buy2 = Math.max(buy2, sell1 - price);

            // 4. Maximize total profit after selling 2nd stock
            sell2 = Math.max(sell2, buy2 + price);
        }

        // The maximum profit after completing at most 2 transactions
        return sell2;
    }
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
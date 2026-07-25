class Solution {
    int sol1(int[] prices) {
        int cs = 0;
        int n = prices.length;
        int m1 = 0, m2 = 0;

        for(int i=1; i<n; i++){
            int diff = prices[i]-prices[i-1];
           
             if(cs+diff < 0){
                if(m1 < m2){
                    m1 = Math.max(m1,cs);
                }
                else{
                    m2 = Math.max(m2,cs);
                }
                cs = 0;
                diff = 0;
            }
            else{
                cs += diff;
            }
        }

        if(m1 < m2){
            m1 = Math.max(m1,cs);
        }
        else{
            m2 = Math.max(m2,cs);
        }

        return m1+m2;
    }
    public int maxProfit(int[] prices) {
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
}
//3 5 7
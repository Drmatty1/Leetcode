class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        Arrays.sort(items , (a,b)-> a[1]-b[1]);

        int maxFactor = 0;
        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
        }

        // int []gain = new int[maxFactor];
        int minCost = items[0][1];
        int []freq  =  new int[maxFactor+1];
        for(int [] i: items) freq[i[0]] ++;

        // Sieve..!!
        int []multiple = new int[maxFactor+1];
        for(int i = 1; i<maxFactor+1; i++){
            for(int m = i; m < maxFactor+1; m+=i){
                multiple[i] += freq[m];
            }
        }

        // calculated at run time 
        // Here Gain[i] = multiple[items[i][0]] ; 

        // minCost = items[0][1];
        // for(int i=0; i<n; i++){
        //     gain[i] = multiple[items[i][0]]-1 ;
        //     if(items[i][1] < minCost) minCost = items[i][1];
        // }

        //  for(int e: gain) System.out.print(e+" ");

        int ans = 0;

        for(int i=0; i<n; i++){
            int gain_i = multiple[items[i][0]]-1;

            if(gain_i > 0 && items[i][1] <= minCost*2 && budget >= items[i][1]){
                int max = Math.min(gain_i,budget/items[i][1]);
                ans += 2*max;
                budget -= items[i][1]*max;
            }
        }

        return ans+budget/minCost;

    }
}
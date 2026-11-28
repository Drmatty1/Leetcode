class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        Arrays.sort(items , (a,b)-> a[1]-b[1]);

        int []gain = new int[n+1];
        int minCost = items[0][1];
        int []freq  =  new int[n+1];
        for(int [] i: items) freq[i[0]] ++;

        // Sieve..!!
        int []multiple = new int[n+1];
        for(int i = 1; i<n+1; i++){
            for(int m = i; m < n+1; m+=i){
                multiple[i] += freq[m];
            }
        }
        // Here Gain[i] = multiple[items[i][0]] ;  
        minCost = items[0][1];
        for(int i=0; i<n; i++){
            gain[i] = multiple[items[i][0]]-1 ;
            if(items[i][1] < minCost) minCost = items[i][1];
        }

        //  for(int e: gain) System.out.print(e+" ");

        int ans = 0;

        for(int i=0; i<n; i++){
            if(gain[i] > 0 && items[i][1] <= minCost*2 && budget >= items[i][1]){
                int max = Math.min(gain[i],budget/items[i][1]);
                ans += 2*max;
                budget -= items[i][1]*max;
                gain[i] -= max;
            }
        }

        return ans+budget/minCost;

    }
}
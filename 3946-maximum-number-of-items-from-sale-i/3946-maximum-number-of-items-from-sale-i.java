class Solution {
    int minCost ;
    int sol(int i, int budget, int[]gain, int [][]it, int[][]dp){
        if( i >= gain.length) return budget/minCost;

        if(dp[i][budget] != -1) return dp[i][budget];

        //take
        int a = 0;
        if(budget >= it[i][1]){
            a = gain[i] + sol(i+1,budget-it[i][1], gain, it, dp);
        }

        //skip
        int b = sol(i+1,budget, gain, it, dp);

        return dp[i][budget] = Math.max(a,b);
    }

    int sol1( int budget, int[]gain, int [][]it){

        int n=gain.length;
        int [][]dp = new int[n+1][budget+1];
        for(int j=0; j<=budget; j++) dp[n][j] = j/minCost;

        for(int i=n-1; i>=0; i--){

            int g = gain[i];
            int c = it[i][1];
            for(int j=0; j<=budget; j++){

                //take
                int a = 0;
                if(j >= c){
                    a = g + dp[i+1][j-c];
                }

                //skip
                int b = dp[i+1][j];

                dp[i][j] = Math.max(a,b);

            }
        }

        return dp[0][budget];
        
    }

    int sol2( int budget, int[]gain, int [][]it){

        int n=gain.length;
        int []next = new int[budget+1];
        for(int j=0; j<=budget; j++) next[j] = j/minCost;

        int []curr ;

        for(int i=n-1; i>=0; i--){

            curr = new int[budget+1];
            
            int g = gain[i];
            int c = it[i][1];
            for(int j=0; j<=budget; j++){

                //take
                int a = 0;
                if(j >= c){
                    a = g + next[j-c];
                }

                //skip
                int b = next[j];

                curr[j] = Math.max(a,b);

            }
            next = curr;
        }

        return next[budget];
        
    }


    public int maximumSaleItems(int[][] items, int budget) {
        int n=items.length;

        // Method 1: To obtain Gain[]   O(n*n)
        int []gain = new int[n];
        // minCost = items[0][1];
        
        // for( int i=0; i<n; i++ ){
            
        //     if(items[i][1] < minCost) minCost = items[i][1];
        //     int ct = 1;

        //     for(int j=0; j<n; j++){
        //         if(i==j)continue;
        //         if(items[j][0]%items[i][0] == 0) ct++;
        //     }
        //     gain[i] = ct;
        // }


        // Method 1: To obtain Gain[]   O(nlogn)
        int []freq  =  new int[1501];
        for(int [] i: items) freq[i[0]] ++;

        int []multiple = new int[1501];

        for(int i = 1; i<=1500; i++){

            for(int m = i; m <= 1500; m+=i){
                multiple[i] += freq[m];
            }
        }

        // Here Gain[i] = multiple[items[i][0]] ;  
        minCost = items[0][1];
        for(int i=0; i<n; i++){
            gain[i] = multiple[items[i][0]] ;  //
            if(items[i][1] < minCost) minCost = items[i][1];
        }
        
        // for(int e: gain) System.out.print(e+" ");


        // int [][]dp = new int[n][budget+1];
        // for(int i=0; i<n; i++)Arrays.fill(dp[i],-1);
        // return sol(0,budget, gain, items, dp);

        // return sol1(budget, gain, items);

        return sol2(budget, gain, items);
      
    }
}
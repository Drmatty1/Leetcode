class Solution {
    
    int solve( int[] n, int i, int xor){
        if( i == n.length ){
            if( xor == 0 )
                return 0;
            return -1;
        }

        // skipped
        int notTake = -1;
        int ans = solve( n, i+1, xor );
        if( ans != -1 ) 
          notTake = ans;
        
        //picked
        int Take = -1;
        ans = solve( n, i+1, xor^n[i] );
        if( ans != -1 ) 
          Take = 1+ans;
        
        return Math.max(notTake, Take);
    }

    int solve1( int[] n, int i, int xor, List<Map<Integer,Integer>> dp ){

        if( i == n.length ){
            if( xor == 0 )
                return 0;
            return -1;
        }

        if( dp.get(i).containsKey(xor) == true )
            return dp.get(i).get(xor);

        // skipped
        int notTake = -1;
        int ans = solve1( n, i+1, xor, dp );
        if( ans != -1 ) 
          notTake = ans;
        
        //picked
        int Take = -1;
        ans = solve1( n, i+1, xor^n[i], dp );
        if( ans != -1 ) 
          Take = 1+ans;
        

        int res = Math.max(notTake, Take);
        dp.get(i).put(xor,res);
        return res ;
    }

    public int minRemovals(int[] nums, int target) {
        int l = nums.length;
        
        List<Map<Integer,Integer>> dp = new ArrayList<>();
        for( int i=0; i<l; i++ ) dp.add(new HashMap<>());

        // int res = solve(nums, 0, target);
        int res = solve1(nums, 0, target, dp);

        if( res == -1 ) return -1;
        return l-res;
    }
}
class Solution {

    boolean sol(int n, int k, int mask, Map<String,Boolean> dp){
        if(n<=0) return true;

        String key = mask+"-";
        if(dp.containsKey(key)) return dp.get(key);

        boolean res = false;
        for(int p=1; p<=k; p++){
            
            if( ((mask>>p)&1) == 1) continue;
            
            if (p >= n) {
                dp.put(key, true);
                return true;
            }

            if (!sol(n - p, k, mask | (1 << p), dp)) {
                dp.put(key, true);
                return true;
            }
        }

        dp.put(key,res);
        return res;
    }
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int n = desiredTotal, k = maxChoosableInteger;

        // if no reuse is available..
        // return desiredTotal==0 || desiredTotal%(maxChoosableInteger+1)!=0;

        // if not..
        if( k*(k+1)/2 < n ) return false;
        if(n == 0)  return true;
        Map<String,Boolean> dp = new HashMap<>();
        return sol(n,k,0,dp);
    }
}
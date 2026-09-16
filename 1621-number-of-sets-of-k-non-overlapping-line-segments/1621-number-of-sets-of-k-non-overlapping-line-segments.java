class Solution {
    int n;
    Integer [][][]memo;
    int mod = 1000000007;
    int sol(int i, int k, int currSeg){
        
        // k is remK

        if(k==0) return 1;
        if(i>=n) return 0;

        if(memo[i][k][currSeg] != null) return memo[i][k][currSeg];

        int ans = 0;
        if(currSeg == 1){
            ans += sol(i+1,k,1); //extend
            ans += sol(i,k-1,0);   //end
        }
        else{
            ans += sol(i+1,k,1);  //start
            ans += sol(i+1,k,0);    //skip
        }

        return memo[i][k][currSeg] = ans%mod;
    }
    public int numberOfSets(int n, int k) {
        this.n = n;
        memo = new Integer[n][k+1][2];
        return sol(0,k,0);
    }
}
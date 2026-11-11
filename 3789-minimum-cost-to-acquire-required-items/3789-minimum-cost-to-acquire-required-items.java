class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if(need1>need2) return minimumCost(cost2,cost1,costBoth,need2,need1);

        //type 1 is less then type2
        if(costBoth>= cost1+cost2){
            return 1L*need1*cost1+1L*need2*cost2;
        }

        long ans = 0;
        long common = Math.min(need2,need1);
        ans += common*costBoth;
        need2 -= common;

        if(cost2 >= costBoth) ans += 1L*need2*costBoth;
        else ans += 1L*need2*cost2;

        return ans;
    }
}
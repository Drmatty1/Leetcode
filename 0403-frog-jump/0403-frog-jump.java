class Solution {
    int []a;
    int n;
    Map<String,Boolean> dp;
    boolean sol(int i, int k){
        if(i==n-1) return true;
        boolean res = false;
        String key = i+"-"+k;
        if(dp.containsKey(key)) return dp.get(key);
        int j = i+1;
        for(int jump=k-1; jump<=k+1; jump++){
            int diff = a[j]-a[i];
            while(j<n-1 && (a[j]-a[i])< jump) j++;
            if((a[j]-a[i]) == jump) res |= sol(j,jump);
        }

        dp.put(key,res);
        return res;
    }
    public boolean canCross(int[] stones) {
        a=stones;
        n = a.length;
        dp = new HashMap<>();
        return a[1]==1&&sol(1,1);
    }
}
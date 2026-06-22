class Solution {
    long sol(String s, int idx, boolean tight, boolean started, int prev, int k, long[][][][]dp, boolean [][][][]vis){
        if( idx == s.length()) return 1;

        if( vis[idx][tight?1:0][started?1:0][prev] ){
            return dp[idx][tight?1:0][started?1:0][prev];
        }

        int ub = tight?(s.charAt(idx)-'0'):9;
        
        long ans = 0;

        for(int d=0; d<=ub; d++){
            boolean newTight = tight&&(d==ub);
            if( started || d != 0  ){
                if( prev == 10 || Math.abs(prev-d) <= k )
                    ans += sol(s, idx+1, newTight, true, d, k, dp, vis );
            }
            else{
                ans += sol(s, idx+1, newTight, false, prev, k, dp, vis );
            }
        }

        vis[idx][tight?1:0][started?1:0][prev] = true;
        return dp[idx][tight?1:0][started?1:0][prev] = ans;

    }
    public long goodIntegers(long l, long r, int k) {
        
        long [][][][]dp = new long[16][2][2][11];
        boolean [][][][]vis = new boolean[16][2][2][11];
        long b = sol( r+"", 0, true, false, 10 , k, dp, vis);
        vis = new boolean[16][2][2][11];
        long a = sol( (l-1)+"", 0, true, false, 10, k, dp, vis );
        // System.out.println(b+" "+a);
        return b-a;
    }
}
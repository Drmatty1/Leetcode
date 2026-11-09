class Solution {
    int[] a;
    int n;
    Boolean[][] dp;

    boolean sol(int i, int k) {
        if (i == n - 1) return true;
        if (dp[i][k] != null) return dp[i][k];

        int j = i + 1;
        for (int jump = k - 1; jump <= k + 1; jump++) {
            if (jump <= 0) continue;
            while (j < n - 1 && (a[j] - a[i]) < jump) j++;
            if ((a[j] - a[i]) == jump && sol(j, jump)) {
                return dp[i][k] = true;
            }
        }

        return dp[i][k] = false;
    }

    public boolean canCross(int[] stones) {
        a = stones;
        n = a.length;
        if (a[1] != 1) return false;
        dp = new Boolean[n][n + 1];
        return sol(1, 1);
    }
}
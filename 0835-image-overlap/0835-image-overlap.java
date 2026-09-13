class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int ans = 0;
        int n = img1.length;

        for (int dx = -(n - 1); dx <= n - 1; dx++) {
            for (int dy = -(n - 1); dy <= n - 1; dy++) {

                int c = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {

                        int x = i + dx;
                        int y = j + dy;

                        if (x >= 0 && x < n && y >= 0 && y < n) {
                            if (img1[i][j] == 1 && img2[x][y] == 1) {
                                c++;
                            }
                        }
                    }
                }
                ans = Math.max(ans,c);
            }
        }

        return ans;
    }
}
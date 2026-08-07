class DetectSquares {
    int[][] map;

    public DetectSquares() {
        map = new int[1001][1001];
    }

    public void add(int[] point) {
        map[point[0]][point[1]]++;
    }

    public int count(int[] point) {

        int x = point[0], y = point[1];
        int ans = 0;

        for (int l = 1; l <= 1000; l++) {

            // top-left
            if (x - l >= 0 && y + l <= 1000)
                ans += map[x - l][y] * map[x][y + l] * map[x - l][y + l];

            // top-right
            if (x + l <= 1000 && y + l <= 1000)
                ans += map[x + l][y] * map[x][y + l] * map[x + l][y + l];

            // bottom-left
            if (x - l >= 0 && y - l >= 0)
                ans += map[x - l][y] * map[x][y - l] * map[x - l][y - l];

            // bottom-right
            if (x + l <= 1000 && y - l >= 0)
                ans += map[x + l][y] * map[x][y - l] * map[x + l][y - l];
        }

        return ans;
    }
}
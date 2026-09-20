class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0) return result;

        int m = heights.length;
        int n = heights[0].length;
        int[][] count = new int[m][n];

        // 1. BFS for Pacific (top row = 0, left col = 0)
        Queue<int[]> pacificQueue = new LinkedList<>();
        boolean[][] visitedPacific = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            pacificQueue.offer(new int[]{r, 0});
            visitedPacific[r][0] = true;
        }
        for (int c = 0; c < n; c++) {
            if (!visitedPacific[0][c]) {
                pacificQueue.offer(new int[]{0, c});
                visitedPacific[0][c] = true;
            }
        }
        runBFS(heights, pacificQueue, visitedPacific, count);

        // 2. BFS for Atlantic (bottom row = m - 1, right col = n - 1)
        Queue<int[]> atlanticQueue = new LinkedList<>();
        boolean[][] visitedAtlantic = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            atlanticQueue.offer(new int[]{r, n - 1});
            visitedAtlantic[r][n - 1] = true;
        }
        for (int c = 0; c < n; c++) {
            if (!visitedAtlantic[m - 1][c]) {
                atlanticQueue.offer(new int[]{m - 1, c});
                visitedAtlantic[m - 1][c] = true;
            }
        }
        runBFS(heights, atlanticQueue, visitedAtlantic, count);

        // 3. Any cell reached by both oceans will have count == 2
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (count[r][c] == 2) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void runBFS(int[][] heights, Queue<int[]> queue, boolean[][] visited, int[][] count) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            count[r][c]++; // Increment for this ocean

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // Must be in-bounds, not yet visited in this BFS, and uphill (>=)
                if (nr >= 0 && nr < m && nc >= 0 && nc < n 
                        && !visited[nr][nc] 
                        && heights[nr][nc] >= heights[r][c]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
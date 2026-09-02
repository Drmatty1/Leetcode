class Solution {
    
    public int maxIncreasingCells(int[][] mat) {
        
        int r = mat.length;
        int c = mat[0].length;

        TreeMap<Integer,List<int[]>> map = new TreeMap<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map.computeIfAbsent(
                        mat[i][j], 
                        k -> new ArrayList<>()
                    ).add(new int[]{i, j});
            }
        }

        int[] rowMax = new int[r];
        int[] colMax = new int[c];
        int ans = 0;

        for (int val : map.keySet()) {

            List<int[]> cells = map.get(val);
            int k = cells.size();
            int[] currentDp = new int[k];

            for(int idx=0; idx<k; idx++){
                int[] cell = cells.get(idx);
                int i = cell[0];
                int j = cell[1];
                currentDp[idx] = 1 + Math.max(rowMax[i], colMax[j]);
                ans = Math.max(ans, currentDp[idx]);
            }

            //Update rowMax and colMax only after evaluating all identical values
            for(int idx=0; idx<k; idx++){
                int[] cell = cells.get(idx);
                int i = cell[0];
                int j = cell[1];

                rowMax[i] = Math.max(rowMax[i], currentDp[idx]);
                colMax[j] = Math.max(colMax[j], currentDp[idx]);
            }

        }

        return ans;
    }
}
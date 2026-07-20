class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int r = grid.length, c = grid[0].length;
        int max = r*c;

        for(int i=0; i<r; i++){
            res.add(new ArrayList<>());
            for(int j=0; j<c; j++){
                res.get(i).add(0);
            }
        }
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                int idx = (i*c+j+k)%max;
                int ni = idx/c;
                int nj = idx%c;
                res.get(ni).set(nj,grid[i][j]);  
            }
        }
        return res;
    }
}
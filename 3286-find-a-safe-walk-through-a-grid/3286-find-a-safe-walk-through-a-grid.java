class Solution {
    int [][]dir = {{1,0},{-1,0},{0,1},{0,-1}};
    boolean check(List<List<Integer>> grid, int i, int j, int hp, boolean [][][]dp, boolean [][][]vis){
        int n = grid.size(), m = grid.get(0).size();
    
        if( hp == 0 ) return false;
        if( i == n-1 && j == m-1 ) return true;

        if(vis[i][j][hp] == true) return dp[i][j][hp];
        if( grid.get(i).get(j) == -1 ) return false;
        int val = grid.get(i).get(j);
        grid.get(i).set(j,-1);

        boolean ans = false;
        for( int []d : dir ){
            int ni = i+d[0], nj = j+d[1];
            if( ni>=0 && ni<n && nj>=0 && nj<m ){
                int newhp = hp;
                if( grid.get(ni).get(nj) == 1 ) newhp = hp-1;
                ans |= check(grid, ni, nj, newhp, dp, vis);
            }
        }
        grid.get(i).set(j,val);

        vis[i][j][hp] = true;
        return dp[i][j][hp] = ans;
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size(), m = grid.get(0).size();
        int hp = health;
        if( grid.get(0).get(0) == 1 ) hp = hp-1;

        //m-1
        // boolean [][][]dp = new boolean[n][m][hp+1];
        // boolean [][][]vis = new boolean[n][m][hp+1];
        // return check(grid, 0, 0, hp, dp, vis);

        //m-2
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->b[2]-a[2]);

        pq.add(new int[]{0,0,hp});
        int val = grid.get(0).get(0);
        grid.get(0).set(0,val-2);

        while(!pq.isEmpty()){

            int[] curr =  pq.poll();
            int i = curr[0], j = curr[1];
            hp = curr[2];

            // val = grid.get(i).get(j);
            // grid.get(i).set(j,val+2);

            if( i == n-1 && j == m-1 ) return hp>0;

            for( int []d : dir ){
                int ni = i+d[0], nj = j+d[1];
                if( ni>=0 && ni<n && nj>=0 && nj<m ){
                    if( grid.get(ni).get(nj) < 0 ) continue;
                    int newhp = hp;
                    if( grid.get(ni).get(nj) == 1 ) newhp = hp-1;
                    pq.add(new int[]{ni,nj,newhp});
                    val = grid.get(ni).get(nj);
                    grid.get(ni).set(nj,val-2);
                }
            }

        }

        return false;

    }
}
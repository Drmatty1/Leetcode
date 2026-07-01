class Solution {
    int [][]dir = {{0,1},{0,-1},{1,0},{-1,0}};

    boolean check( int[][]mat, int i, int j, int t, Set<Integer> vis ){
        int n = mat.length;

        if( mat[i][j] < t ) return false;
        if( i == n-1 && j == i ) return true;

        vis.add(i*n+j);
        boolean ans  = false;

        for(int []d : dir){
            int ni = i+d[0];
            int nj = j+d[1];
            if( ni >=0 && ni < n && nj >= 0 && nj < n &&
                vis.contains(ni*n+nj) == false 
            ){  
                boolean temp = check(mat, ni, nj, t, vis);
                ans |= temp;
            }
        }

        return ans;
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();
        int [][]mat = new int[n][n];

        Queue<int []> q = new ArrayDeque<>();
        Set<Integer> vis = new HashSet<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid.get(i).get(j) == 1){
                    mat[i][j] = 0;
                    q.add(new int[]{i,j}) ;
                    vis.add(i*n+j);
                }
            }
        }

        while( !q.isEmpty() ){

            int s = q.size();
            for(int t=0; t<s; t++){

                int []curr = q.poll();
                int i=curr[0], j = curr[1];
                int val = mat[i][j];

                for(int []d : dir){
                    int ni = i+d[0];
                    int nj = j+d[1];
                    if( ni >=0 && ni < n && nj >= 0 && nj < n &&
                        vis.contains(ni*n+nj) == false ){
                        mat[ni][nj] = val+1;
                        q.add(new int[]{ni,nj});
                        vis.add(ni*n+nj);
                    }
                }

            }

        }

        int ps = 0;
        int lb = 0, ub = n;
        while( lb <= ub ){
            int mid = (ub-lb)/2+lb;
            vis = new HashSet<>();
            if( check(mat, 0, 0, mid, vis)  ){
                lb = mid+1;
                ps = mid;
            }
            else{
                ub = mid-1;
            }
        }

        return ps;

    }
}
/*  dist matrix
3   2   1   0
2   3   2   1
1   2   3   2
0   1   2   3
*/

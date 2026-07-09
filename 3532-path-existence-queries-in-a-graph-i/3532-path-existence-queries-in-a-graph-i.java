class Solution {
    boolean check(int u, int v, int[] maxJump){
        if( u > v ) return check(v, u, maxJump);
        
        if( maxJump[u] > v ) return true;
        if(maxJump[u] == u+1 ) return false;
        return check(maxJump[u]-1, v, maxJump);

    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int []maxJump = new int[n];
       
        int j=0;
        for(int i=0; i<n; i++){
            while( j < n && nums[j]-nums[i] <= maxDiff ) j++;
            maxJump[i] = j;
        }

        // for(int e: maxJump) System.out.print(e+" ");

        int m = queries.length;
        boolean []ans = new boolean[m];
        for(int k=0; k<m; k++){
            ans[k] = check(queries[k][0],queries[k][1],maxJump);
            if(ans[k] == true ){
                int u = Math.min(queries[k][0],queries[k][1]);
                int v = Math.max(queries[k][0],queries[k][1]);
                maxJump[u] = Math.max(v+1, maxJump[u]);
            }
        }

        return ans;

    }
}





















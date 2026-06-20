class Solution {
    int dist(int x1, int y1, int x2, int y2){
        int l = (x2-x1+y2-y1)/2;
        return y1+l;
    }
    public int maxBuilding(int n, int[][] restrictions) {

        Arrays.sort(restrictions, (a,b)->Integer.compare(a[0],b[0]));
        int s = restrictions.length;

        int []prev = {1,0};
        for(int i=0; i<s; i++){
            int []curr = restrictions[i];
            curr[1] = Math.min( curr[1], curr[0]-prev[0]+prev[1] );
            prev = curr;
        }
        
        for(int i=s-1; i>=1; i--){
            prev = restrictions[i-1];
            int []curr = restrictions[i];
            prev[1] = Math.min( prev[1], curr[0]-prev[0]+curr[1] );
        }

        prev = new int[]{1,0};
        int ans = 0;
        for(int []curr : restrictions ){

            int res = dist(prev[0],prev[1], curr[0],curr[1]);
            ans = Math.max(ans, res);
            prev = curr;
        }

        if(prev[0] != n )  ans = Math.max(ans, prev[1]+n-prev[0] );
        return ans;
    }
}
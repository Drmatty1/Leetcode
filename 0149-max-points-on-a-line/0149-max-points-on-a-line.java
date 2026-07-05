class Solution {
    int[] eqn(int []p1, int []p2){
        int a  = p1[0], b = p1[1], c = p2[0], d = p2[1];
        return new int[]{c-a,b-d,(a-c)*b + (d-b)*a};
    }
    int sol1(int[][] points) {
        int ans = 1, n = points.length;
        // Set<String> vis = new HashSet<>();

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){

                int []eqn = eqn(points[i],points[j]);
                // String key = eqn[0]+"-"+eqn[1]+"-"+eqn[2];
                // if( vis.contains(key) ) continue;

                int res = 0;
                for(int k = j+1; k<n; k++){
                    int x = points[k][0], y = points[k][1];
                    int t = y*eqn[0]+x*eqn[1]+eqn[2];
                    if( t == 0 ) res ++;
                }
                // vis.add(key);
                ans = Math.max(ans,res+2);
            }
        }
        return ans;
    }

    public int maxPoints(int[][] points) {
        int ans = 1, n = points.length;

        for(int i=0; i<n; i++){

            int x1 = points[i][0], y1 = points[i][1];

            for(int j=i+1; j<n; j++){

                int x2 = points[j][0], y2 = points[j][1];
                int res = 0;

                for(int k = j+1; k<n; k++){
                    int x3 = points[k][0], y3 = points[k][1];
                    int area = x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2);
                    if( area == 0 ) res ++;
                }
    
                ans = Math.max(ans,res+2);
            }
        }
        return ans;
    }
}
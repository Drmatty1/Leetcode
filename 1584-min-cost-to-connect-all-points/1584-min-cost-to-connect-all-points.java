class Solution {
    int getDist(int []a, int []b){
        return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[1],b[1])
        );

        pq.add(new int[]{0,0});
        boolean []vis = new boolean[n];
        int cost = 0;
        int edgeConnected = 0;

        while(!pq.isEmpty() && edgeConnected < n){
            
            int []curr = pq.poll();
            int i = curr[0], wt = curr[1];

            if(vis[i]) continue;
            vis[i] = true;  

            cost += wt;
            edgeConnected++;

            for(int j=0; j<n; j++){
                if(vis[j] || i==j) continue;
                int nWt = getDist(points[i],points[j]);
                pq.add(new int[]{j,nWt});
            }

        }

        return cost;
    }
}  
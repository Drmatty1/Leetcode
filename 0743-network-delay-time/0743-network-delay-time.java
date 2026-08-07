class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());

        for(int []e: times){
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new int[]{v,w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[1],b[1])
        );

        int []dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        boolean []vis = new boolean[n+1];

        dist[k] = 0;
        pq.add(new int[]{k,0});

        while(!pq.isEmpty()){

            int []curr = pq.poll();
            int u = curr[0], w = curr[1];

            vis[u] = true;

            for(int []next: adj.get(u)){
                int v = next[0], nW = next[1];
                if(vis[v] == false){
                    if(dist[u]+nW < dist[v]){
                        dist[v] = dist[u]+nW;
                        pq.add(new int[]{v,dist[v]});
                    }
                }
            }

        }

        int min = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            int d = dist[i];
            min = Math.max(min,d);
            if(d == Integer.MAX_VALUE) return -1;
        }

        return min;
    }
}
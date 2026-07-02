class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int []edge: flights){
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[]{v,w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{src,0,0});

        int []minStop = new int[n];
        Arrays.fill(minStop, Integer.MAX_VALUE);
        minStop[src] = 0;

        while(!pq.isEmpty()){

            int []curr = pq.poll();
            int node = curr[0], stop = curr[1], w = curr[2];

            if( node == dst ) return w;

            if( stop > minStop[node] || stop > k ) continue;

            minStop[node] = stop;

            for(int[] next: adj.get(node)){

               pq.add( new int[]{ next[0], stop+1, w + next[1] } );
        
            }

        }

        return -1;
    }
}

//
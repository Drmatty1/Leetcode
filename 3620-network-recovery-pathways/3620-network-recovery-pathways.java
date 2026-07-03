class Solution {

    boolean check( List<List<int[]>> adj, long mid, long k, int n, boolean[] online ){

        Queue<long[]> q = new ArrayDeque<>();
        q.add(new long[]{0,0});
        long []minWt = new long[n];
        Arrays.fill(minWt, Long.MAX_VALUE);
        minWt[0] = 0;

        while( !q.isEmpty() ){

            int s = q.size();
            for(int t=0; t<s; t++){

                long []curr = q.poll();
                int node = (int)curr[0];
                long w = curr[1];

                if( node == n-1 ) return true;

                for(int []next : adj.get(node)){
                    int nextNode = next[0];
                    long edgeWt = next[1];
                    if( edgeWt < mid ) continue;

                    long nextW = w+edgeWt;
                    if( nextW < minWt[nextNode] && online[nextNode] == true && nextW <= k ){
                        minWt[nextNode] = nextW;
                        q.add(new long[]{nextNode,nextW});
                    }
                }

            }
        }
        return false;
    }

    boolean check1( List<List<int[]>> adj, long mid, long k, int n, boolean[] online ){

        PriorityQueue<long[]> q = new PriorityQueue<>(
            (a,b)->Long.compare(a[1],b[1])
        );
        q.add(new long[]{0,0});
        long []minWt = new long[n];
        Arrays.fill(minWt, Long.MAX_VALUE);
        minWt[0] = 0;

        while( !q.isEmpty() ){

            int s = q.size();

            long []curr = q.poll();
            int node = (int)curr[0];
            long w = curr[1];

            if( node == n-1 ) return true;

            if( w > minWt[node] ) continue;

            for(int []next : adj.get(node)){
                int nextNode = next[0];
                long edgeWt = next[1];
                if( edgeWt < mid ) continue;

                long nextW = w+edgeWt;
                if( nextW < minWt[nextNode] && online[nextNode] == true && nextW <= k ){
                    minWt[nextNode] = nextW;
                    q.add(new long[]{nextNode,nextW});
                }
            }

        }
        return false;
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        int ub = 0;
        for(int []edge : edges){
            int u = edge[0], v = edge[1], c = edge[2];
            adj.get(u).add(new int[]{v,c});
            ub = Math.max(ub, c);
        }

        int lb = 0, ps = -1;
        while( lb <= ub ){
            int mid = (ub-lb)/2+lb;
            if( check1(adj, mid, k, n, online) ){
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
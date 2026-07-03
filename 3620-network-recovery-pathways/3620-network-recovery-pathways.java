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
            
            // stale cond.
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
/**
Because the graph is a DAG (Directed Acyclic Graph), the shortest path from any node to the destination (n-1) can be solved using dynamic programming.

For a fixed guess `mid`, define:

f(node) = Minimum total cost to reach node (n-1) starting from `node`, using only:
- edges with weight >= mid
- online intermediate nodes

The recurrence is:

f(node) = min(edgeWt + f(neighbor))

taken over all valid outgoing edges from `node`.

Base case:
f(n-1) = 0

Why memoization works:

If multiple paths reach the same node X, the minimum cost from X to the destination is always the same because the graph has no cycles. Once we compute f(X), we store it in a memo array. Any future DFS reaching X simply returns the stored value instead of recomputing the entire subtree.

This avoids repeated work and makes each node's DP value computed only once for a given `mid`.

Overall algorithm:

1. Binary search on the answer (`mid`), which represents the minimum edge weight allowed on the path.

2. For each `mid`:
   - Ignore every edge whose weight is less than `mid`.
   - Ignore any offline intermediate node.

3. Run a memoized DFS (DP) from node `0` to compute the minimum total cost to reach node `n-1`.

4. If the minimum total cost is <= k, then a valid path exists with score at least `mid`, so try a larger `mid`.
   Otherwise, reduce `mid`.

Time Complexity:
- DP (memoized DFS) per check: O(n + m)
- Binary search: O(log C), where C is the maximum edge weight.
- Overall: O((n + m) * log C)

(You can reduce the binary search to O(log m) by searching only over the sorted unique edge weights.)
 */
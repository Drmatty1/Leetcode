class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        int[] degree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for( int i=0; i<n; i++ )adj.add(new LinkedList<>());
        
        for( int[]e : edges ){
            adj.get( e[0] ).add(e[1]);
            adj.get( e[1] ).add(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for( int i=0; i<n; i++ )  if( degree[i] == 1 ) q.add(i);

        int rem = n;
        while( rem > 2 ){
            
            int s = q.size();
            rem = rem-s;
            
            while( s-->0 ){
                int c = q.poll();
                int nbh = adj.get(c).get(0);
                degree[nbh]--;
                if( degree[nbh] == 1 ) q.add(nbh);
                adj.get(nbh).remove(Integer.valueOf(c));
            }
            
        }
       List<Integer> ans = new ArrayList<>();
       while(!q.isEmpty()) ans.add(q.poll());
       if( ans.isEmpty() ) ans.add(0);
       return ans;
    }
}
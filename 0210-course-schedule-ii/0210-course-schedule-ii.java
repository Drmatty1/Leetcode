class Solution {
        int[] topoSort( int numCourses, int[][] prerequisites ){
        int V = numCourses;

        List<List<Integer>> adj = new ArrayList<>();
        int []indegree = new int[V];
        for( int i=0; i<V; i++ ) adj.add(new ArrayList<>());
        for( int[]e : prerequisites ){ 
            adj.get(e[1]).add(e[0]);
            indegree[e[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for( int i=0; i<V; i++ ) if(indegree[i]==0) q.add(i);

        int[] ans = new int[V];
        int l=0;
        while( !q.isEmpty() ){

            int curr = q.poll();
            ans[l++]=curr;

            for( int j : adj.get(curr) ){
                indegree[j]--;
                if( indegree[j] == 0 ) q.add(j);
            }

        }
        return l==V?ans:(new int[0]);
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        return topoSort(numCourses,prerequisites);
    }
}
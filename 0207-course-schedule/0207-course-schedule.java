class Solution {
    boolean dfs( int i, Map<Integer,List<Integer>> adj,int []visited, int []callStack){
        visited[i] = 1;
        callStack[i] = 1;
        boolean ans = false;
        if( !adj.containsKey(i) ){
            callStack[i] = 0;
            return false;
        }
        for( int e : adj.get(i) ){
            if( callStack[e] == 1 ) return true;
            if( visited[e] == 0 ){
                ans |= dfs(e,adj,visited,callStack);
            }
        }
        
        callStack[i] = 0;
        return ans;   
    }
    public boolean isCyclic(int V, int[][] edges) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        for( int[]e : edges ) 
            adj.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            
        int []visited = new int[V];
        int []callStack = new int[V];
        boolean ans = false;
        for( int i = 0; i < V; i++ ){
            if( visited[i] == 0 ){
                ans |= dfs(i,adj,visited,callStack);
            }
            if( ans == true ) return true;
        }
        return ans;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return !isCyclic( numCourses, prerequisites );
    }
}
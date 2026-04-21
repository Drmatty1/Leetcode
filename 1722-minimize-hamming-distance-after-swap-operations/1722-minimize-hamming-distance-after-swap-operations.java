class Solution {
    
    class DSU{
        int []par;
        DSU(int n){
            par = new int[n];
            for(int i=0; i<n; i++)par[i]=i;
        }
       
        int find(int p){
            if(par[p]==p)return p;
            return par[p] = find(par[p]);
        }
        void union(int a, int b){
            int pa = find(a), pb = find(b);
            if( pa != pb ){
                par[pb] = pa;
            }
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        
        int ans=0;
        int n = source.length;
        DSU d = new DSU(n);

        for( int []a : allowedSwaps ){
            d.union(a[0],a[1]);
        }

        Map<Integer,List<Integer>> map = new HashMap<>();

        for( int i=0; i<n; i++ ){
            int root = d.find(i);
            map.computeIfAbsent(root,k->new ArrayList<>()).add(i);
        }

        for( List<Integer> l : map.values() ){

            Map<Integer,Integer> freq = new HashMap<>();
            for( int idx : l ){
                int key = source[idx];
                freq.put(key, freq.getOrDefault(key,0)+1);
            }
        
            for( int idx : l ){
                int key = target[idx];
                if( freq.getOrDefault(key,-1) > 0 ){
                    freq.put(key, freq.get(key)-1);
                }
                else ans++;
            }

        }

        return ans;
    
    }
}
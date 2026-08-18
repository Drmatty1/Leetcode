class Solution {
    Map<Integer,Integer> map;
    int m;
    public Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        for(int e: blacklist) map.put(e,-1);

        m = n-map.size(); 

        //mapping of blocked -> non-blocked ( m ... | blocked )
        for(int e: blacklist){
            if(e < m){
                while(map.containsKey(n-1)) n--;
                map.put(e,n-1);
                n--;
            }
        }
    }
    

    public int pick() {
        int r = (int)(Math.random() * m);
        if(map.containsKey(r)) return map.get(r);
        return r;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
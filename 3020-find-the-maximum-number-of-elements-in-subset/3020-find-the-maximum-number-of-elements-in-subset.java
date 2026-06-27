class Solution {
    int chainLen( Map<Integer,Integer> map, Map<Integer,Integer> dp, int v ){

        if( dp.containsKey(v) ) return dp.get(v);

        int freq = map.getOrDefault(v,0);
        
        int ans = 0;
        if( freq >= 2 ){
            if( v == 1 )  map.put(v, map.get(v)-2);
            ans = 2+chainLen( map, dp, v*v);
        }
        else if( freq == 1 ){
            ans = 1;
        }
        else ans = -1;

        dp.put(v, ans);
        return ans;

    }
    public int maximumLength(int[] nums) {
        
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> dp = new HashMap<>();
        for(int e: nums){
            map.put(e, map.getOrDefault(e,0)+1);
        }

        int ans= 0 ;
        for(int e: nums){
            int v = e;
            int len = 0;
            while( map.getOrDefault(v,0) > 1 ){
                len += 2;
                if( v == 1 )  map.put(v, map.get(v)-2);
                v = v*v;
            }
            if( map.getOrDefault(v,0) == 1 ) len ++;
            else len --;

            ans = Math.max(ans, len);
        }

        return ans;

    }
}
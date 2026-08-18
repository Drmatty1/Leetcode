class Solution {
    Map<Integer,Integer> map ;
    boolean count(int e, int k){
        
        int freq = map.get(e);
        int len=0;
        while(map.containsKey(e)){
            len++;
            if(map.get(e) < freq) return false;

            map.put(e,map.get(e)-freq);
            if(map.get(e) == 0) map.remove(e);

            e++;
            if(len==k) return true;
        }
        return false;

    }
    public boolean isPossibleDivide(int[] nums, int k) {

        int n = nums.length;
        if(n%k != 0) return false;
        map = new HashMap<>();

        for(int e: nums){
            map.put(e,map.getOrDefault(e,0)+1);
        }

        int []keys = new int[map.size()];
        int i=0;
        for(int e: map.keySet()){
            keys[i++] = e;
        }

        Arrays.sort(keys);

        int count = 0;

        for(int e: keys){
            if(map.containsKey(e)==false) continue;
            boolean res = count(e,k);
            // System.out.println(e+" "+res);
            if(res==false) return false;
        }

        return true;

    }
}
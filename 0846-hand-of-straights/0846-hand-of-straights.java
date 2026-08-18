class Solution {
    Map<Integer,Integer> map ;
    boolean count(int e, int k){
        int len = 0;
        while(map.containsKey(e)){
            len++;
            map.put(e,map.get(e)-1);
            if(map.get(e) == 0) map.remove(e);
            e++;
            if(len==k) return true;
        }
        return false;
    }
    boolean sol(int[] nums, int k) {

        int n = nums.length;
        if(n%k != 0) return false;
        map = new HashMap<>();

        Arrays.sort(nums);
        for(int e: nums){
            map.put(e,map.getOrDefault(e,0)+1);
        }

        int count = 0;

        for(int e: nums){
            if(map.containsKey(e)==false) continue;
            boolean res = count(e,k);
            // System.out.println(e+" "+res);
            if(res==false) return false;
        }

        return true;

    }
    public boolean isNStraightHand(int[] hand, int groupSize) {
        return sol(hand,groupSize);
    }
}
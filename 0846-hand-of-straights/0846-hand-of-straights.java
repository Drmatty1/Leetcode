class Solution {
    Map<Integer,Integer> map ;
    boolean count(int e, int k){
        int len = 0;
        while(map.containsKey(e)){
            len++;

            int freq = map.get(e);
            if(freq > 1)  map.put(e,freq-1);
            else map.remove(e);

            e++;
            if(len==k) return true;
        }
        return false;
    }
    // O(nlogn)
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


    boolean find(int []arr, int i, int k){
        int n = arr.length;
        int count = 0;
        int next = arr[i];

        for(int j=i; j<n && count < k; j++ ){
            if(arr[j]==next){
                count++;
                next++;
                arr[j] = -1;
            }
        }

        return count==k;
    }
    boolean sol1(int []a, int k){
        Arrays.sort(a);
        for(int i=0; i<a.length; i++){
            if(a[i]>=0){
                if(find(a,i,k)==false) return false;
            }
        }
        return true;
    }


    public boolean isNStraightHand(int[] hand, int groupSize) {
        // return sol(hand,groupSize);

        return sol1(hand,groupSize);

    }
}
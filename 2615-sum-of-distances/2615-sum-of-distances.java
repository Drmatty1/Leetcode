class Solution {
    public long[] distance(int[] nums) {
        int n1 = nums.length;
        Map<Integer,List<Integer>> map = new HashMap<>();
       
        for(int i=0; i<n1; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        long []res = new long[n1];

        for (List<Integer> list : map.values()) {
            int n = list.size();
            
            long sum = list.get(0);
            for( int i=1; i<n; i++ ){
                sum += list.get(i);
            }

            long p = 0;

            for( int i=0; i<n; i++ ){
                long a = i, b = n-i-1;
                long l = i==0?0:p;
                long r = (i==n-1)?0:(sum-p-list.get(i));
                p += list.get(i);
                res[list.get(i)] = a*list.get(i)-l + r-b*list.get(i);
            }

        }
        return res;
    }
}
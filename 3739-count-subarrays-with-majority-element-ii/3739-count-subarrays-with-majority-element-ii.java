class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int []pre = new int[n+1];

        for(int i=0; i<n; i++){
            pre[i+1] = pre[i] + (target==nums[i]?1:(-1));
        }

        // for(int e: pre) System.out.print(e+" ");

        long ans = 0 ;
        long smallerCount = 0;
        Map <Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        // 0  -1   0   1   0     Pre array
        // 0   1   2   3   4     index 
        for(int i=1; i<=n; i++){

            if( pre[i] > pre[i-1] ){
                smallerCount += map.getOrDefault(pre[i-1],0);
            }
            else{
                smallerCount -= map.getOrDefault(pre[i],0);
            }

            ans += smallerCount;
            map.put( pre[i], map.getOrDefault(pre[i],0)+1 );

        }

        return ans;

    }
}
//  0  1  2  1  2  3  4  3  2
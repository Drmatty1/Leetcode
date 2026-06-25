class Solution {

    long sol1(int[] nums, int target) {
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
    long sol11(int[] nums, int target) {
        int n = nums.length;
        int []pre = new int[n+1];

        for(int i=0; i<n; i++){
            pre[i+1] = pre[i] + (target==nums[i]?1:(-1));
        }

        // for(int e: pre) System.out.print(e+" ");

        long ans = 0 ;
        long smallerCount = 0;
        // Map <Integer,Integer> map = new HashMap<>();
        int []map = new int[2*n+1];
        // map.put(0,1);
        map[0+n] = 1;

        // 0  -1   0   1   0     Pre array
        // 0   1   2   3   4     index 
        for(int i=1; i<=n; i++){

            if( pre[i] > pre[i-1] ){
                // smallerCount += map.getOrDefault(pre[i-1],0);
                smallerCount += map[n + pre[i-1]];
            }
            else{
                // smallerCount -= map.getOrDefault(pre[i],0);
                smallerCount -= map[n + pre[i]];
            }

            ans += smallerCount;

            // map.put( pre[i], map.getOrDefault(pre[i],0)+1 );
            map[n + pre[i]] ++;

        }

        return ans;

    }
    long sol12(int[] nums, int target) {
        int n = nums.length;
        // int []pre = new int[n+1];

        // for(int i=0; i<n; i++){
        //     pre[i+1] = pre[i] + (target==nums[i]?1:(-1));
        // }

        // for(int e: pre) System.out.print(e+" ");

        long ans = 0 ;
        long smallerCount = 0;
        // Map <Integer,Integer> map = new HashMap<>();
        int []map = new int[2*n+1];
        // map.put(0,1);
        map[0+n] = 1;

        // 0  -1   0   1   0     Pre array
        // 0   1   2   3   4     index 
        int sum = 0;
        for(int i=1; i<=n; i++){
            int currSum = (target==nums[i-1]?1:(-1)) + sum;
            if( currSum > sum ){
                // smallerCount += map.getOrDefault(pre[i-1],0);
                smallerCount += map[n + sum];
            }
            else{
                // smallerCount -= map.getOrDefault(pre[i],0);
                smallerCount -= map[n + currSum];
            }

            ans += smallerCount;
            
            // map.put( pre[i], map.getOrDefault(pre[i],0)+1 );
            map[n + currSum] ++;

            sum = currSum;
        }

        return ans;

    }

    public long countMajoritySubarrays(int[] nums, int target) {

        // return sol11(nums, target);
        return sol12(nums, target);

    }
}
//  0  1  2  1  2  3  4  3  2
class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length/3;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long []arr = new long[3*n+1];

        for(int i=3*n-1; i>=n; i--){
            
            if(pq.size() < n ){
                pq.add(nums[i]);
                arr[i] = arr[i+1]+nums[i];
            }
            else{
                int min = pq.poll();
                if(nums[i] > min ){
                    arr[i] = arr[i+1] - min + nums[i];
                    pq.add(nums[i]);
                }
                else{
                    pq.add(min);
                    arr[i] = arr[i+1];
                }
            }
        }

        // for(long e: arr) System.out.print(e+" ");

        long diff = Long.MAX_VALUE;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(
            (a,b) -> b-a
        );
        long sum = 0;
        for(int i=0; i<2*n; i++){
            if( i < n ){
                sum += nums[i];
                pq1.add(nums[i]);
            }
            else{
                int max = pq1.poll();
                if( max > nums[i] ){
                    sum = sum - max + nums[i];
                    pq1.add(nums[i]);
                }
                else{
                    pq1.add(max);
                }
            }
            if(pq1.size() == n ){
                diff = Math.min(diff, sum - arr[i+1]);
            }
        }

        return diff;
    }
}


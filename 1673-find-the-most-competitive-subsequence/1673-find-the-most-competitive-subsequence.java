class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(
            (a,b)-> {
                if(nums[a]!=nums[b]) return nums[a]-nums[b];
                return a-b;
            }
        );
        int n = nums.length;

        for(int i=0; i<=n-k; i++){
            pq.add(i);
        }

        int []res = new int[k];
        int idx = 0;
        int m = pq.poll();
        res[idx++] = nums[m];


        int i=n-k+1;
        while(i<n){
            pq.add(i);
            while( pq.peek() <= m) pq.poll();

            m = pq.poll();
            res[idx++] = nums[m];

            i++;
        }

        return res;

    }
}
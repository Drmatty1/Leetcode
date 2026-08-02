class Solution {
    static class FenwickTree {
        int[] bit;
        int n;

        FenwickTree(int n) {
            this.n = n;
            bit = new int[n + 1];
        }

        void update(int idx, int val) {
            idx++;
            while (idx <= n) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            idx++;
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }
    public long countRatioSubarrays(int[] nums, int a, int b) { 
        int n = nums.length;
        long []pre = new long[n+1];

        long sum = 0;
        for(int i=0; i<n; i++){
            if(nums[i]%2 == 0) sum += b;
            else sum -= a;
            pre[i+1] = sum;
        }

        long[] uniqueP = Arrays.stream(pre).distinct().sorted().toArray();
        Map<Long, Integer> rank = new HashMap<>();
        for (int i = 0; i < uniqueP.length; i++) {
            rank.put(uniqueP[i], i+1 );
        }


        FenwickTree ft = new FenwickTree(uniqueP.length);

        long validSubarraysCount = 0;

        for(int j=0; j<=n; j++){
            int r = rank.get(pre[j]);

            // j = total elements processed so far
            // query(tree, r - 1) = elements strictly smaller than P[j]
            validSubarraysCount += (j - ft.query( r - 1));

            ft.update(r,1);
        }

        return validSubarraysCount;

    }
}
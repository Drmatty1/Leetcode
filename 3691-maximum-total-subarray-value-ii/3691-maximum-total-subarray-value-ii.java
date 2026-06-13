class Solution {
    int [][] sx;
    int [][] sn;
    int []log;

    void buildSparse(int[] nums) {

        int n = nums.length;
        log = new int[n+1];
        for(int i=2; i<=n; i++) log[i] = log[i/2]+1;
        int levels = log[n]+1;

        sx = new int[n][levels];
        sn = new int[n][levels];
        for(int i=0; i<n; i++) sn[i][0] = sx[i][0] = nums[i];

        for(int j=1; j<levels; j++){
            for(int i = 0; i<(n-(1<<j)+1); i++ ){
                sx[i][j] = Math.max(sx[i][j-1],sx[i+(1<<(j-1))][j-1]);
                sn[i][j] = Math.min(sn[i][j-1],sn[i+(1<<(j-1))][j-1]);
            }
        }
    }
    int querymax(int l, int r){
        int J = log[r-l+1];
        return Math.max(sx[l][J],sx[r-(1<<J)+1][J]); 
    }
    int querymin(int l, int r){
        int J = log[r-l+1];
        return Math.min(sn[l][J],sn[r-(1<<J)+1][J]); 
    }
    int value( int l, int r){
        return querymax(l,r)-querymin(l,r);
    }

    public long maxTotalValue(int[] nums, int k) {

        int n = nums.length;

        buildSparse(nums);

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b) -> Long.compare(b[2], a[2]));

        HashSet<Long> vis = new HashSet<>();

        long key = encode(0, n - 1);
        vis.add(key);

        pq.add(new int[]{ 0, n - 1, value(0, n - 1) });

        long ans = 0;

        while (k-- > 0 && !pq.isEmpty()) {

            int[] cur = pq.poll();

            ans += cur[2];

            int l = cur[0];
            int r = cur[1];

            if (l + 1 <= r) {

                long k1 = encode(l + 1, r);

                if (vis.add(k1)) {
                    pq.add(new int[]{ l+1, r, value(l+1, r) } );
                }
            }

            if (l <= r - 1) {

                long k2 = encode(l, r - 1);

                if (vis.add(k2)) {
                   pq.add(new int[]{ l, r- 1, value(l, r - 1) });
                }
            }
        }

        return ans;
    }

    long encode(int l, int r) {
        return ((long) l << 32) | (r & 0xffffffffL);
    }

    
}
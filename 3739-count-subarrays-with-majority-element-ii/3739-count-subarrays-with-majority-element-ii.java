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


    long countAndMerge(int[] arr, int l, int m, int r) {
      
        // Counts in two subarrays
        int n1 = m - l + 1, n2 = r - m;

        // Set up two arrays for left and right halves
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++)
            left[i] = arr[i + l];
        for (int j = 0; j < n2; j++)
            right[j] = arr[m + 1 + j];

        // Initialize inversion count (or result)
        // and merge two halves
        long res = 0;
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {

            // No increment in inversion count
            // if left[] has a smaller
            if (left[i] < right[j]){
                arr[k++] = left[i++];
            }
            // If right <= left, then it is greater than i 
            // elements because left[] is sorted
            else {
                res += i;
                arr[k++] = right[j++];
            }
        }

        // Merge remaining elements
        while (i < n1){
            arr[k++] = left[i++];
        }
        while (j < n2){
            arr[k++] = right[j++];
            res += i;
        }

        return res;
    }
    long countInv(int[] arr, int l, int r) {
        long res = 0;
        if (l < r) {
            int m = (r - l) / 2 + l;

            // Recursively count inversions
            // in the left and right halves
            res += countInv(arr, l, m);
            res += countInv(arr, m + 1, r);

            // Count inversions such that greater element is in 
            // the left half and smaller in the right half
            res += countAndMerge(arr, l, m, r);
        }
        return res;
    }
    

    class Seg {
        int[] seg;
        int n;

        Seg(int s) {
            n = s;
            seg = new int[4 * n];
        }

        int query(int[] seg, int low, int high, int qlow, int qhigh, int pos) {
            // total overlap
            if (qlow <= low && qhigh >= high) return seg[pos];

            // no overlap
            if (qlow > high || qhigh < low) return 0;

            // partial overlap
            int mid = (high - low) / 2 + low;
            return query(seg, low, mid, qlow, qhigh, 2 * pos + 1) + 
                   query(seg, mid + 1, high, qlow, qhigh, 2 * pos + 2);
        }

        void update(int[] seg, int low, int high, int value, int idx, int pos) {
            if (low == high) {
                seg[pos] += value;
                return;
            }

            int mid = (high - low) / 2 + low;
            if (idx <= mid)  
                update(seg, low, mid, value, idx, 2 * pos + 1);
            else 
                update(seg, mid + 1, high, value, idx, 2 * pos + 2);

            // FIX 1: Overwrite rather than accumulate to avoid double counting
            seg[pos] = seg[2 * pos + 1] + seg[2 * pos + 2];
        }

        int find(int qlow, int qhigh) {
            if (qlow > qhigh) return 0;
            return query(seg, 0, n - 1, qlow, qhigh, 0);
        }

        void put(int idx, int val) {
            update(seg, 0, n - 1, val, idx, 0);
        }
    }

    public long sol3(int[] nums, int target) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + (target == nums[i] ? 1 : -1);
        }

        // Freq Array size m , as pre[i] lie b/w -n to n. 
        int m = 2 * n + 1;
        Seg seg = new Seg(m);
        
        // FIX 2: Adjusted offset to exactly fit the [0, 2*n] range
        int offset = n; 
        long ans = 0;

        for (int i = 0; i <= n; i++) {
            int idx = pre[i];
            ans += seg.find(0, idx + offset - 1);
            seg.put(idx + offset, 1);
        }

        return ans;
    }


    public long countMajoritySubarrays(int[] nums, int target) {
        
        //m-1
        // return sol11(nums, target);
        // return sol12(nums, target);

        //m-2
        // int n = nums.length;
        // int []pre = new int[n+1];
        // for(int i=0; i<n; i++){
        //     pre[i+1] = pre[i] + (target==nums[i]?1:(-1));
        // }
        // long ans = countInv(pre, 0, n);
        // return ans;


        // m-3
        return sol3(nums, target);
    }
}
//  0  1  2  1  2  3  4  3  2
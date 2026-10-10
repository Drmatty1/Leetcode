class Solution {
    long sol1(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length, m = 0;
        long k = (long) k1 + k2;
        int[] diff = new int[n];

        for (int i = 0; i < n; i++)
            m = Math.max(m, diff[i] = Math.abs(nums1[i] - nums2[i]));

        int[] bucket = new int[m + 1];
        for (int x : diff) bucket[x]++;

        for (int i = m; i > 0 && k > 0; i--) {
            int take = (int) Math.min(bucket[i], k);
            bucket[i] -= take;
            bucket[i - 1] += take;
            k -= take;
        }

        long ans = 0;
        for (int i = 1; i <= m; i++)
            ans += (long) bucket[i] * i * i;

        return ans;
    }

    long sol2(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        int maxDiff = 0;
        long totalDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            totalDiff += diff[i];
        }

        long k = (long) k1 + k2;

        // If total operations can reduce all differences to 0
        if (k >= totalDiff) {
            return 0L;
        }

        // Binary search for the minimal ceiling T in [0, maxDiff]
        int low = 0, high = maxDiff;
        int T = maxDiff;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long cost = 0;

            for (int d : diff) {
                if (d > mid) {
                    cost += (d - mid);
                }
            }

            if (cost <= k) {
                T = mid;
                high = mid - 1; // Try to find a lower ceiling
            } else {
                low = mid + 1;  // Ceiling is too low, exceeds budget k
            }
        }

        // Calculate operations consumed to cap all elements at T
        long costAtT = 0;
        for (int d : diff) {
            if (d > T) {
                costAtT += (d - T);
            }
        }

        // Remaining operations to distribute among elements at height T
        long kRem = k - costAtT;

        // Calculate the minimum sum of squared differences
        long result = 0;
        for (int d : diff) {
            long val = Math.min(d, T);

            // Shave down remaining operations from pillars sitting at height T
            if (val == T && kRem > 0 && val > 0) {
                val--;
                kRem--;
            }

            result += val * val;
        }

        return result;
    }

    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        return sol2(nums1, nums2, k1, k2);
    }
}
// 4 4 4 3
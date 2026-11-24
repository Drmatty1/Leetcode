class Solution {

    public int getMask(int x) {

        int[] primes = {2, 3, 5, 7};
        int mask = 0;

        for (int i = 0; i < 4; i++) {
            if (x % primes[i] == 0) {
                mask |= (1 << i);
            }
        }

        return mask;
    }

    public int solOP(int[] nums) {

        int n = nums.length;

        // Last occurrence of prime factors 2, 3, 5, 7
        int[] last = {-1, -1, -1, -1};

        int left = 0;
        int best = 0;

        for (int right = 0; right < n; right++) {

            int mask = getMask(nums[right]);

            // Find the minimum valid left boundary
            for (int p = 0; p < 4; p++) {

                if ((mask & (1 << p)) != 0) {

                    left = Math.max(left, last[p] + 1);
                }
            }

            // Update last occurrence of current prime factors
            for (int p = 0; p < 4; p++) {

                if ((mask & (1 << p)) != 0) {

                    last[p] = right;
                }
            }

            best = Math.max(best, right - left + 1);
        }

        // Every subarray of length 2 is product equivalent
        return Math.max(2, best);
    }


    boolean can(int[] nums, int len) {

        if (len == 2) return true;

        int[] cnt = new int[4];
        int bad = 0;

        for (int i = 0; i < nums.length; i++) {

            int mask = getMask(nums[i]);

            // Add current number
            for (int p = 0; p < 4; p++) {
                if ((mask & (1 << p)) != 0) {
                    if (cnt[p] == 1) bad++;
                    cnt[p]++;
                }
            }

            // Remove element outside current window
            if (i >= len) {

                int oldMask = getMask(nums[i - len]);

                for (int p = 0; p < 4; p++) {
                    if ((oldMask & (1 << p)) != 0) {
                        cnt[p]--;

                        if (cnt[p] == 1) bad--;
                    }
                }
            }

            // Check complete window
            if (i >= len - 1 && bad == 0) {
                return true;
            }
        }

        return false;
    }

    public int solBS(int[] nums) {

        int low = 2;
        int high = nums.length;
        int ans = 2;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (can(nums, mid)) {

                ans = mid;
                low = mid + 1;  // Try a larger length

            } else {

                high = mid - 1; // Try a smaller length
            }
        }

        return ans;
    }

    public int maxLength(int[] nums) {

        return solBS(nums);
    }
}
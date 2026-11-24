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

    public int maxLength(int[] nums) {

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
}
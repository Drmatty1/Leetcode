class Solution {
    public int sortableIntegers(int[] nums) {

        int n = nums.length;

        // Find all divisors of n in O(sqrt(n))
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i * i != n) {
                    divisors.add(n / i);
                }
            }
        }

        long totalSum = 0;
        for (int k : divisors) {
            if (isValid(nums, n, k)) {
                totalSum += k;
            }
        }

        return (int) totalSum;
    }

    private boolean isValid(int[] nums, int n, int k) {
        int prevMax = -1;

        for (int start = 0; start < n; start += k) {
            int drops = 0;
            int bMin = nums[start];
            int bMax = nums[start];

            for (int i = 0; i < k; i++) {
                int curr = nums[start + i];
                bMin = Math.min(bMin, curr);
                bMax = Math.max(bMax, curr);

                if (i < k - 1 && nums[start + i] > nums[start + i + 1]) {
                    drops++;
                }
            }

            // A block can be cyclically sorted iff:
            // 1. It has 0 drops, OR
            // 2. It has exactly 1 drop AND the wrap-around condition holds (last <= first)
            if (drops > 1) return false;
            if (drops == 1 && nums[start + k - 1] > nums[start]) return false;

            // Cross-block monotonicity: max of previous block <= min of current block
            if (prevMax != -1 && prevMax > bMin) {
                return false;
            }

            prevMax = bMax;
        }

        return true;
    }
}
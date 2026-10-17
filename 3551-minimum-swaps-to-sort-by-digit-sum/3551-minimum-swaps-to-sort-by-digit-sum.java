class Solution {
    static class Item implements Comparable<Item> {
        int val;
        int digitSum;
        int originalIdx;

        Item(int val, int originalIdx) {
            this.val = val;
            this.originalIdx = originalIdx;
            this.digitSum = computeDigitSum(val);
        }

        private static int computeDigitSum(int n) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            return sum;
        }

        @Override
        public int compareTo(Item other) {
            if (this.digitSum != other.digitSum) {
                return Integer.compare(this.digitSum, other.digitSum);
            }
            return Integer.compare(this.val, other.val);
        }
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(nums[i], i);
        }

        // 1. Sort by digit sum ascending, then by numerical value ascending
        Arrays.sort(items);

        // 2. Count disjoint permutation cycles
        boolean[] visited = new boolean[n];
        int numCycles = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                numCycles++;
                int curr = i;
                while (!visited[curr]) {
                    visited[curr] = true;
                    // Follow where the element currently sitting at 'curr' belongs
                    curr = items[curr].originalIdx;
                }
            }
        }

        // Total swaps = N - (number of disjoint cycles)
        return n - numCycles;
    }
}
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;

        long[] cumSum = new long[n];
        cumSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            cumSum[i] = nums[i] + cumSum[i - 1];
        }

        // NGR[i] = n (Next Greater Element to the Right)
        int[] NGR = new int[n];
        Arrays.fill(NGR, n);
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                NGR[st.pop()] = i;
            }
            st.push(i);
        }

        // Operations[i] = total operations to make [i...n-1] non-decreasing
        long[] Operations = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int m = NGR[i];

            // i to m-1 segment
            long segmentOprns = (1L * nums[i] * (m - i)) - rangeSum(cumSum, i, m - 1);
            Operations[i] = segmentOprns + Operations[m];
        }

        // Sliding Window Maximum
        Deque<Integer> deq = new ArrayDeque<>();
        long result = 0;

        int i = 0;
        int j = 0;

        while (j < n) {
            while (!deq.isEmpty() && nums[deq.peekLast()] < nums[j]) {
                deq.pollLast();
            }
            deq.offerLast(j);

            // Shrink if required
            while (i <= j) {
                int m = deq.peekFirst();

                // i...j
                long oprnsCount = (Operations[i] - Operations[m])
                                + (1L * nums[m] * (j - m + 1))
                                - rangeSum(cumSum, m, j);

                if (oprnsCount <= k) {
                    break;
                }

                i++;
                if (!deq.isEmpty() && deq.peekFirst() < i) {
                    deq.pollFirst();
                }
            }

            result += (j - i + 1);
            j++;
        }

        return result;
    }

    private long rangeSum(long[] cumSum, int i, int j) {
        if (i > j) {
            return 0;
        }
        return cumSum[j] - ((i > 0) ? cumSum[i - 1] : 0);
    }
}
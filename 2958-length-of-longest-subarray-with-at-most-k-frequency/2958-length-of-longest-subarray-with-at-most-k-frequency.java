class Solution {
    
    //tle O(n*logn)
    boolean check(int[] nums, int mid, int k) {

        Map<Integer, Integer> freq = new HashMap<>();
        TreeMap<Integer, Integer> count = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {

            // ---------------- ADD nums[i] ----------------

            int e = nums[i];

            int oldFreq = freq.getOrDefault(e, 0);
            int newFreq = oldFreq + 1;

            freq.put(e, newFreq);

            // Remove old frequency from count
            if (oldFreq > 0) {
                count.put(oldFreq, count.get(oldFreq) - 1);

                if (count.get(oldFreq) == 0)
                    count.remove(oldFreq);
            }

            // Add new frequency to count
            count.put(newFreq, count.getOrDefault(newFreq, 0) + 1);


            if (i >= mid) {

                int prev = nums[i - mid];

                int prevOldFreq = freq.get(prev);
                int prevNewFreq = prevOldFreq - 1;

                // Remove old frequency
                count.put(
                    prevOldFreq,
                    count.get(prevOldFreq) - 1
                );

                if (count.get(prevOldFreq) == 0)
                    count.remove(prevOldFreq);

                // Update freq
                if (prevNewFreq == 0) {
                    freq.remove(prev);
                } else {
                    freq.put(prev, prevNewFreq);

                    // Add new frequency
                    count.put(
                        prevNewFreq,
                        count.getOrDefault(prevNewFreq, 0) + 1
                    );
                }
            }


            // Window has reached size mid
            if (i >= mid - 1) {
                if (count.lastKey() <= k)
                    return true;
            }
        }

        return false;
    }

    //O(n)
    boolean check_OP(int[] nums, int windowSize, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int invalidCount = 0; // Tracks elements exceeding max frequency k

        for (int i = 0; i < nums.length; i++) {
            // 1. Add element entering the window
            int in = nums[i];
            freq.put(in, freq.getOrDefault(in, 0) + 1);
            if (freq.get(in) == k + 1) {
                invalidCount++;
            }

            // 2. Remove element leaving the window
            if (i >= windowSize) {
                int out = nums[i - windowSize];
                if (freq.get(out) == k + 1) {
                    invalidCount--;
                }
                freq.put(out, freq.get(out) - 1);
            }

            // 3. Check if current window of size `windowSize` is valid
            if (i >= windowSize - 1 && invalidCount == 0) {
                return true;
            }
        }

        return false;
    }

    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int i=0,j=n;
        while(i<j){
            int mid = (j-i+1)/2+i;
            if(check_OP(nums,mid,k)){
                i = mid;
            }
            else{
                j=mid-1;
            }
        }
        return i;
    }
}
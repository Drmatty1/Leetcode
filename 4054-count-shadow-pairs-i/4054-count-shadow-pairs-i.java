class Solution {
    long sol1(int[] nums) {
        long res = 0;
        int[] s = new int[nums.length];
        int size = 0;

        for (int a : nums) {
            // Pop elements strictly greater than 'a'
            while (size > 0 && s[size - 1] > a) {
                size--;
            }
            // Count elements strictly less than 'a'
            res += bisectLeft(s, size, a);
            // Push 'a' to stack
            s[size++] = a;
        }

        return res;
    }

    int bisectLeft(int[] s, int size, int target) {
        int low = 0, high = size;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (s[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    

    long sol2(int[] nums) {
        long ans = 0;
        long totalElements = 0;
        
        // Deque acts as our stack. It stores arrays of size 2: [value, frequency_count]
        Deque<int[]> stack = new ArrayDeque<>();

        for (int x : nums) {
            // 1. Pop disqualified candidates (elements strictly greater than x)
            while (!stack.isEmpty() && stack.peek()[0] > x) {
                totalElements -= stack.pop()[1];
            }

            // 2. Count valid pairs
            int equalCount = 0;
            if (!stack.isEmpty() && stack.peek()[0] == x) {
                equalCount = stack.peek()[1];
            }
            
            // Valid pairs are all elements currently in stack strictly less than x
            ans += (totalElements - equalCount);

            // 3. Push the new candidate or update its frequency
            if (!stack.isEmpty() && stack.peek()[0] == x) {
                stack.peek()[1]++;
            } else {
                stack.push(new int[]{x, 1});
            }
            
            totalElements++;
        }
        
        return ans;
    }


    public long shadowPairs(int[] nums) {
        return sol1(nums);
    }
}
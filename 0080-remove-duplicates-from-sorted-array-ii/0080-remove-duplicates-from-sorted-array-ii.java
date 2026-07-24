class Solution {
    int sol1(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;

        int i = 0; // Points to the start of the current unique number group
        int max = 100000;
        int temp = max;
        int count = 0;
        int currentCount = 1; // Tracks occurrences of the number at nums[i]
        
        // PASS 1: Mark duplicates exceeding 2 occurrences with a placeholder
        // We use a clean linear scan to maintain O(n) time complexity
        for (int j = 1; j < n; j++) {
            if (nums[j] == nums[i]) {
                currentCount++;
                if (currentCount > 2) {
                    count++;
                    nums[j] = temp++; // Mark as an unwanted duplicate
                }
            } else {
                // Found a new distinct number! 
                // This is where your commented logic 'i = j' properly belongs.
                i = j; 
                currentCount = 1; // Reset the frequency tracker for the new number
            }
        }

        // PASS 2: Shift valid elements forward (Your exact original cleanup loop)
        i = 0;
        int j = 0;
        while (j < n) {
            if (nums[j] < max) {
                nums[i] = nums[j];
                i++;
                j++;
            } else {
                j++;
            }
        }

        return n - count;
    }
    int sol2(int[] nums) {
        int i=0, j = 2, n = nums.length;
        int max = 100000;
        int temp = max;
        int count = 0;

        if(n <= 2 )return n;


        while(j<n){
            if(nums[j] == nums[i]) {
                count++;
                nums[j] = temp++;
                j++;
            }
            else{
                
                // i++;
                i = j-1;
                j = i+2;
            }
        }

        i = 0;
        j = 0;
        while(j<n){
            if(nums[j] < max){
                nums[i] = nums[j];
                i++;
                j++;
            }
            else{
                j++;
            }
        }

        return n-count;

    }
    int solOP(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int k = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k++] = nums[i];
            }
        }

        return k;
    }
    public int removeDuplicates(int[] nums) {
        
        return sol2(nums);

    }
}
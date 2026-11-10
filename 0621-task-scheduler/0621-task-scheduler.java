class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];  
        int maxCount = 0;

        for (char task : tasks) {
            freq[task - 'A']++;
            maxCount = Math.max(maxCount, freq[task - 'A']);
        }

        int time = (maxCount - 1) * (n + 1);
        for (int f : freq) {
            if (f == maxCount) {
                time++;
            }
        }

        return Math.max(tasks.length, time);
    }
}
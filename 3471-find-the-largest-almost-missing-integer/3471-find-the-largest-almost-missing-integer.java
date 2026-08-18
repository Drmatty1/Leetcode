class Solution {
    public int largestInteger(int[] nums, int k) {
        int ans = -1;
        int n =nums.length;

        if (k == n) return Arrays.stream(nums).max().getAsInt();
        if(k==1){
            int []freq = new int[51];
            for(int i=0; i<n; i++){
                freq[nums[i]]++;
            }
            for(int i=50; i>=0; i--) if(freq[i]==1) return i;
            return -1;
        }

        int []freq1 = new int[51];
        int []freq2 = new int[51];
        int []freq3 = new int[51];

        for(int i=0; i<n; i++){
            if(i<k) freq1[nums[i]] ++;
            else if(i<n-k) freq2[nums[i]]++;
            else freq3[nums[i]]++;
        }

        if(freq2[nums[0]] == 0 && freq3[nums[0]] == 0 && freq1[nums[0]] == 1 ) ans = nums[0];
        if(freq1[nums[n-1]] == 0 && freq2[nums[n-1]] == 0 && freq3[nums[n-1]] == 1 ) 
            ans = Math.max(ans,nums[n-1]);
    
        return ans;
    }
}
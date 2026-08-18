class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int n = nums.length;
        int []pre = new int[n+1];
        for(int i=0; i<n; i++){
            pre[i+1] = pre[i]+(nums[i]==0?1:0);
        }

        int []suf = new int[n+1];
        for(int i=n-1; i>=0; i--){
            suf[i] = suf[i+1] + nums[i];
        }

        int max = 0;
        for(int i=0; i<=n; i++){
            max = Math.max(max,pre[i]+suf[i]);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<=n; i++){
            if(pre[i]+suf[i] == max) ans.add(i);
        }

        return ans;

    }
}
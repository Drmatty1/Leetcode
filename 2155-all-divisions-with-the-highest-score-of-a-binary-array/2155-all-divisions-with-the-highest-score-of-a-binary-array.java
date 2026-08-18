class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int n = nums.length;
        // int []pre = new int[n+1];
        // for(int i=0; i<n; i++){
        //     pre[i+1] = pre[i]+(nums[i]==0?1:0);
        // }

        int []suf = new int[n+1];
        for(int i=n-1; i>=0; i--){
            suf[i] = suf[i+1] + nums[i];
        }

        int max = 0;
        int pre = 0;
        for(int i=0; i<=n; i++){
            if(i>0) pre += (nums[i-1]==0?1:0);
            max = Math.max(max,pre+suf[i]);
        }

        List<Integer> ans = new ArrayList<>();
        pre = 0;
        for(int i=0; i<=n; i++){
            if(i>0) pre += (nums[i-1]==0?1:0);
            if(pre+suf[i] == max) ans.add(i);
        }

        return ans;

    }
}
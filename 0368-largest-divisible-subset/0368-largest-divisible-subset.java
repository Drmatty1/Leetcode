class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int []par = new int[n];
        for(int i=0; i<n; i++) par[i]=i;

        Arrays.sort(nums);
        int []dp = new int[n];
        Arrays.fill(dp,1);

        int max = 1;
        for(int i=0; i<n; i++){

            for(int j=0; j<i; j++){
                if(nums[i]%nums[j] == 0 && dp[j]+1>dp[i]){
                    dp[i] = dp[j]+1;
                    par[i] = j;
                }
                max = Math.max(dp[i],max);
            }
        }
        // for(int e: dp) System.out.print(e+" ");
        // System.out.println("--");
        // for(int e: par) System.out.print(e+" ");

        for(int i=n-1; i>=0; i--){
            if(dp[i] == max){
                int curr = i;
                while(par[curr] != curr){
                    ans.add(nums[curr]);
                    curr = par[curr];
                }
                ans.add(nums[curr]);
                break;
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}
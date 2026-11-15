class Solution {
    int M = 1000000007;
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int []pre = new int[n+1];
        for(int i=0; i<n; i++){
            pre[i+1] = pre[i]+arr[i];
        }

        int O=0,E=1;
        int ans=0;
        for(int i=0; i<n; i++){
            int currSum = pre[i+1];
            if(currSum%2==0){
                ans = (ans+O)%M;
            }
            else ans = (ans+E)%M;

            if(currSum%2 == 0) E++;
            else O++;
        }

        return ans;
    }
}
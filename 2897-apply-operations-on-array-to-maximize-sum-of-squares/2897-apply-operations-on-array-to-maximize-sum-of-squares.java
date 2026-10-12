class Solution {
    public int maxSum(List<Integer> nums, int k) {
        
        int []bits = new int[30];
        for(int e: nums){
            for(int i=0; i<30; i++){
                bits[i] += (e&1);
                e = e>>1;
            }
        }
        
        int mod = 1000000007;
        long ans = 0;

        while(k-->0){
            int res = 0;
            for(int i=29; i>=0; i--){
                res = res<<1;
                if(bits[i] > 0){
                    res += 1;
                    bits[i] --;
                }
            }
            ans = (ans+(1L*res*res))%mod;
        }

        return (int)ans;
    }
}

// 1 0 0 0
// 0 1 0 1
// 0 1 1 0
// 0 0 1 0
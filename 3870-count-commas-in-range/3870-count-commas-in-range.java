class Solution {

    public int countCommas(int n) {
        int ans = n-999;
        // while(n>=1000){
        //     ans++;
        //     n--;
        // }
        return ans>0?ans:0;
    }
}
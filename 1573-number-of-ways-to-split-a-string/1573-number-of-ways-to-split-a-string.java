class Solution {
    int mod = 1000000007;
    int sol(int a, int b){
        long res = 1;
        res = (res*a*(a-1))/2;
        return (int)(res%mod);
    }
    public int numWays(String s) {

        int one = 0;
        char[]arr = s.toCharArray();
        for(char c: arr) one += c-'0';

        if(one%3 != 0)return 0;
        if( one == 0 ) return sol(arr.length-1,2);

        long ans = 1;
        int choice = 0;
        int count = 0;
        int target = one/3;

        int i=0;
        while(i<arr.length){
            char c = arr[i++];
            count += c-'0';

            if( count > target ){
                ans = (ans*choice)%mod;
                count = 1;
                choice = 0;
            }

            if(count == target){
                choice++;
            }
        }

        // ans = (ans*choice)%mod;

        return (int)ans;

    }
}
 /**

3c2  3!
    2!*1!


  */






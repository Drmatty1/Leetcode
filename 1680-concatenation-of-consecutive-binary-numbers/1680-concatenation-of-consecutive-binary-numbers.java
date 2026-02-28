class Solution {
 
    public int concatenatedBinary(int n) {
        int M = (int)1e9+7;
        int ans = 0;
        for( int i=1; i<=n; i++ ){
            String temp = Integer.toBinaryString(i);
            for (int j = 0; j < temp.length(); j++) {
                char c = temp.charAt(j);
                ans = ( (ans<<1)+(c-'0') )%M ;
            }
        }
        return (ans);
    }
}
class Solution {
    StringBuilder getStr(int i){
        StringBuilder ans = new StringBuilder();
        while( i !=0 ){
            ans.append((char)((i&1)+'0'));
            i = i>>1;
        }
        return ans.reverse();
    }
    public int concatenatedBinary(int n) {
        int M = (int)1e9+7;
        int ans = 0;
        for( int i=1; i<=n; i++ ){
            StringBuilder temp = getStr(i);
            for (int j = 0; j < temp.length(); j++) {
                char c = temp.charAt(j);
                ans = ( (ans<<1)+(c-'0') )%M ;
            }
        }
        return (ans);
    }
}
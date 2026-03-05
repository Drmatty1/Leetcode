class Solution {
    int start0(String s){
        int l = s.length();
        boolean prev = false;
        int ans=0;
        for( int i=0; i<l; i++ ){

            boolean c = s.charAt(i)=='0';

            if(c==prev){
                ans++;
                prev = !c;
            }
            else prev = c;

        }
        return ans;
    }
    int start1(String s){
        int l = s.length();
        boolean prev = true;
        int ans=0;
        for( int i=0; i<l; i++ ){

            boolean c = s.charAt(i)=='0';

            if(c==prev){
                ans++;
                prev = !c;
            }
            else prev = c;

        }
        return ans;
    }
    public int minOperations(String s) {
        return Math.min(start0(s),start1(s));
    }
        
}
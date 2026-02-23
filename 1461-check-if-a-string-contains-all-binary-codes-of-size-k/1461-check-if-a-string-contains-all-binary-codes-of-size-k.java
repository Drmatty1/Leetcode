class Solution {
    public boolean hasAllCodes(String s, int k) {
        
        if( k >= s.length() ) return false;

        int range = (int)Math.pow(2,k);
        int []arr = new int[range];
        int t = 0, n = s.length();

        
        for( int i=0; i<k; i++ ){
            int a = s.charAt(i)-'0';
            t = (t<<1)|(a);
        }

        arr[t] = 1;
        int ref = (int)Math.pow(2,k-1)-1;

        for( int i=k; i<n; i++ ){
            int a = s.charAt(i)-'0';
            t = t&ref;
            t = (t<<1)|(a);
            arr[t] = 1;
        }

        for( int i=0; i<range; i++ ){
            if(arr[i]==0)return false;
        }
        return true;
    }
}
class Solution {
    public char findKthBit(int n, int k) {
        if( k==1 )  return '0';
        if( (k & (k-1)) == 0  ) return '1';
        StringBuilder s = new StringBuilder("0");
        StringBuilder I = new StringBuilder("1");
        int i=2;
        while( i <= n ){
            StringBuilder s1 = new StringBuilder(s);
            StringBuilder I1 = new StringBuilder(I);
            s.append("1").append(I1.reverse());
            I.append("0").append(s1.reverse());
            i++;
        }

        return s.charAt(k-1);
    }
}
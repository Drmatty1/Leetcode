class Solution {

    int op( char[] a, int i ){
        int n = a.length;
        int c = 0;
        int l = i-1, r = i+1;
        while( l >=0 && r < n && a[l]==a[r]  ){
            c++;
            l--;
            r++;
        }
        return c+1;
    }
    int ep( char[] a, int i ){
        int n = a.length;
        int c = 0;
        int l = i, r = i+1;
        while( l >=0 && r < n && a[l]==a[r]  ){
            c++;
            l--;
            r++;
        }
        return (c);
    }

    public int countSubstrings(String s) {
        int l = s.length();
        char[] a = s.toCharArray();
        int ans = 0;
        for( int i = 0; i<l; i++ ){
            int p = op(a,i);
            int q = ep(a,i);
            ans += p+q;
        }

        return ans;

    }
}
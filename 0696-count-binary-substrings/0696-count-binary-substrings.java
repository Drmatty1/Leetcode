class Solution {
    int sol(String s, int i){
        
        int n = s.length();
        int c0 = 0, c1 = 0, ans = 0;

        if( s.charAt(i) == '0' ){
            
            while( i<n && s.charAt(i) == '0' ){
                c0++; 
                i++;
            }
            if( i == n ) return 0;
            ans = sol( s, i );
            while( i<n && s.charAt(i) == '1' ){
                c1++; 
                i++;
            }
            
        }
        else{
            while( i<n && s.charAt(i) == '1' ){
                c1++; 
                i++;
            }
            if( i == n ) return 0;
            ans = sol( s, i );
            while( i<n && s.charAt(i) == '0' ){
                c0++; 
                i++;
            }
        }
        int curr = Math.min(c0,c1);
        return curr+ans;
    }
    public int countBinarySubstrings(String s) {
        // return sol(s,0);
        int curr=1, prev=0, ans=0, n=s.length();
        for( int i=1; i<n; i++ ){
            if( s.charAt(i) == s.charAt(i-1) ) curr++;
            else{
                ans += Math.min(curr,prev);
                prev = curr;
                curr=1;
            }
        }
        ans += Math.min(curr,prev);
        return ans;
    }
}
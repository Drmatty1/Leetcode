class Solution {
    // passed in cpp with dp(Unoredred_map : key i++"."+j+"."+c)
    boolean sol(char []s, char[]t, int i, int j, boolean rep){
        if( i==s.length ) return true;
        if( j==t.length ) return false;

        if( s[i] == t[j] ) return sol(s,t,i+1,j+1,rep);
        
        boolean res = false;
        if( rep == true ) res |= sol(s,t,i+1,j+1,false);
        res |= sol(s,t,i,j+1,rep);

        return res;
        
    }

    boolean solPreSuff(String s, String t) {
        char []a = s.toCharArray();
        char []b = t.toCharArray();
    
        int n1 = a.length, n2 = b.length;
        int []pre = new int[n1];
        Arrays.fill(pre,-1);
        int []suf = new int[n1];
        Arrays.fill(suf,-1);

        int i=0 , j = 0;
        while( i < n1 && j < n2){
            if(a[i] == b[j]){
                pre[i] = j;
                i++;
                j++;
            }
            else{
                j++;
            }
        }

        // already a subseq
        if (pre[n1 - 1] != -1) return true;
        
        i = n1-1 ;
        j = n2-1;
        while( i >=0 && j >= 0 ){
            if(a[i] == b[j]){
                suf[i] = j;
                i--;
                j--;
            }
            else{
                j--;
            }
        }

        for( i=0; i<n1; i++){
            
            int l = (i>0) ? pre[i-1] : -1;
            int r = (i<n1-1) ? suf[i+1] : n2 ;

            if( l == -1 && i > 0 ) continue;
            if( r == -1 && i < n1-1 ) continue;
            
            if( r-l > 1 ) return true;
            
        }

        // if( n1 == 1 ) return true;

        return false;
        
    }

    boolean solOP_DP(char []a, char[]b){
        int n1 = a.length, n2 = b.length;
        int i=0 , j = 0;
        for(char c: b) {
            j = Math.max(i+1, j + (a[j] == c?1:0));
            i += (a[i] == c?1:0);
            if( i == n1 || j == n1  ) return true;
        }
        return false;
    }

    public boolean canMakeSubsequence(String s, String t) {
        char []a = s.toCharArray();
        char []b = t.toCharArray();
    
        return solOP_DP(a,b);
        
    }
}
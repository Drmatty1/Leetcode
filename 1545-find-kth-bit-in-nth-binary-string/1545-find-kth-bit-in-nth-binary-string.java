class Solution {
    static List<StringBuilder>dp=new ArrayList<>();
    static {
        for(int i=0; i<21; i++) dp.add(new StringBuilder(""));
    }
    int solve(int n,int k){
        if( k == 1 )  return 0;
        if( (k & (k-1)) == 0  ) return 1;
        
        int lenleft =  (1<<(n-1));
        if( k < lenleft ){
            return solve(n-1,k);
        }
        else{
            return solve(n-1,2*lenleft-k)^1;
        }
    }
    char solve2(int n, int k){
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
    char solve3(int n, int k){
        if( k==1 )  return '0';
        if( (k & (k-1)) == 0  ) return '1';

        if( dp.get(n).length()>0 ) return dp.get(n).charAt(k-1);

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
        dp.set(n,s);
        return s.charAt(k-1);
    }
    public char findKthBit(int n, int k) {
        // return (char)(solve(n,k)+'0');
        return solve3(n,k);
    }
}
class Solution {
    int mod = 1000000007;
    
    long power(long a, long n){
        if( n == 0 ) return 1;

        if( n %2 == 0 ){
            long res = power(a, n/2);
            return (res*res)%mod;
        }
        else{
            long res = power(a, n/2);
            return (a * ((res*res)%mod) ) % mod ;
        }

    }

    public int countAnagrams(String s) {
        String[] parts = s.split(" ");
        long ans = 1;

        for( String str: parts ){

            int []freq = new int[26];
            char []arr = str.toCharArray();
            for( char c : arr ){
                freq[c-'a'] ++;
            }

            int len = arr.length;

            // (a*b*c*d...)%mod = (((a*b%mod)*c%mod)*d%mod)..
            // (N/D)%mod = N*D^(-1)%mod 
            // D^(-1) = D^(mod−2)%(mod)
            long D = 1, N = 1;

            for(int f: freq ){
                long temp = 1;
                for(int i=2; i<=f; i++){
                    temp = (temp*i)%mod;
                }
                D = (D*temp)%mod;
            }

            for(int i=1; i<=len; i++) {
                N = (N*i) % mod;
            }

            // System.out.println(N+" "+D+" "+len);

            long DInv = power(D, mod-2);

            long res = (N*DInv) % mod;

            ans = (ans*res)%mod;
        }

        return (int)ans;
    }
}
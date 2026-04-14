class Solution {
    long c(long n){
        long count=0;
        while(n%2==0){
            count++;
            n = n/2;
        }
        return count;
    }
    public int integerReplacement(int t) {
        long ans=0;
        long n = t;
        while( n > 1 ){
            while( n%2 == 0 ){
                ans++;
                n = n/2;
            }
            if( n == 1 ) break;
            if( n == 3 ){
                n = 1;
                ans+=2;
                break;
            }

            long a = c(1L*n-1), b = c(1L*n+1);
            if( b <= a  ){
                n = n-1;
                ans++;
            }
            else{
                n=n+1;
                ans++;
            }
        }
        return (int)ans;
    }
}
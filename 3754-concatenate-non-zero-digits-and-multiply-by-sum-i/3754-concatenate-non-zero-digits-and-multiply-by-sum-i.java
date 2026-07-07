class Solution {
    public long sumAndMultiply(int n) {
        long a = 0;
        int sum = 0;
        while( n > 0 ){
            if( n%10 > 0 )
                a = a*10 + n%10;
            sum += n%10;
            n /= 10;
        }
        long res = 0;
        while(a > 0){
            res = res*10 + a%10;
            a /= 10;
        }
        return res*sum;
    }
}
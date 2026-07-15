class Solution {
    int gcd(int a, int b){
        if(a==0)return b;
        return gcd(b%a, a);
    }
    public int gcdOfOddEvenSums(int n) {
        int sumEven = n*(n+1);
        int sumOdd = sumEven-n;
        return gcd(sumEven,sumOdd);
    }
}
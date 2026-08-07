class Solution {
    long gcd(long a, long b){
        if(a==0) return b;
        return gcd(b%a,a);
    }
    public String smallestNumber(String num, long t) {
        
        // checking if t is valid i.e t has 2,3,5,7 not 13,..
        long temp = t;
        for(int i=2; i<=9; i++){
            while(temp%i == 0) temp /= i;
        }
        if(temp != 1) return "-1";

        // precomputing pref that contains factor of t
        int n = num.length();
        long[] rem = new long[n + 1];
        rem[0] = t;
        int pos = n - 1;

        char[] numChars = num.toCharArray();
        for (int i = 0; i < n; i++) {
            if (numChars[i] == '0') {
                pos = i;
                break;
            }
            rem[i + 1] = rem[i] / gcd(rem[i], numChars[i] - '0');
        }

        if (rem[n] == 1) {
            return num;
        }


        //check if num can be modified to get req string
        for(int i=pos; i>=0; i--){
            while( ++numChars[i] <= '9' ){
                long tNow = rem[i]/gcd(rem[i],numChars[i]-'0');

                int k = 9;

                for (int j = n - 1; j > i; j--) {
                    while (tNow % k != 0) {
                        k--;
                    }
                    tNow /= k;
                    numChars[j] = (char) ('0' + k);
                }

                if (tNow == 1) {
                    return new String(numChars);
                }

            }
        }



        // any string of len = num.len , not suffic. 
        StringBuilder sb = new StringBuilder();
        for(int f=9; f>=2; f--){
            while(t%f==0){
                sb.append(String.valueOf(f));
                t /= f;
            }
        }
        while(sb.length() <= n) sb.append("1");

        return sb.reverse().toString();
    }
}
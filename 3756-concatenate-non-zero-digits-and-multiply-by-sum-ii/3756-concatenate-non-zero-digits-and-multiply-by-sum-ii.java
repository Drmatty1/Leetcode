class Solution {
    int []log ;
    int[] nz;
    int[][] lookup;
    int mod = 1000000007;
    long power(long a, long b) {
        long res = 1;
        a %= mod;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }

        return res;
    }
    int merge(int a, int b, int l){
        long res = (a * power(10, l) + b)%mod;
        return (int)res;
    }
    int find( int l, int r ){
        int len = r-l+1;
        if( len == 1 ) return lookup[l][0];

        int pow2 = log[len];

        int curr = lookup[l][pow2];
        if( (1<<pow2) == len ) return curr;

        int next = find(l+(1<<pow2),r);
        int nextCnt = nz[r + 1] - nz[l+(1<<pow2)];
        return merge(curr, next, nextCnt );

    }
    int[] sparseTableSoln(String s, int[][] queries) {
        int n = s.length();
        int []arr = new int[n];
        
        int j=0;
        for(char c: s.toCharArray()) arr[j++] = c-'0';

        nz = new int[n + 1];
        for (int i = 0; i < n; i++) {
            nz[i + 1] = nz[i] + (arr[i] != 0 ? 1 : 0);
        }

        log = new int[n+2];
        for(int i=2; i<=n; i++) log[i] = log[i/2]+1;

        int lvl = log[n]+1;
        lookup = new int[n][lvl];

        for(int i=0; i<n; i++){
            lookup[i][0] = arr[i];
        }

        for(int l = 1; l <= lvl; l++){
            for(int i=0; i<n-(1<<l)+1; i++){

                int a = lookup[i][l-1];
                int b = lookup[i+(1<<(l-1))][l-1];
                int rightCnt = nz[i+(1<<l)] - nz[i+(1<<(l-1))];
                lookup[i][l] = merge(a,b,rightCnt);
            }
        }

        for(int i=1; i<n; i++){
            arr[i] += arr[i-1];
        }

        int qlen = queries.length;
        int []ans=  new int[qlen];
        for(int i=0; i<qlen; i++){

            int l = queries[i][0];
            int r = queries[i][1];
            long res = find(l,r);
            long sum = arr[r]-(l>0?arr[l-1]:0);
            long temp = (res*sum)%mod;
            ans[i] = (int)temp;
        }

        return ans;
    }


    // m-2 best simple
    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length();
        long mod = 1_000_000_007L;

        // Precompute powers of 10 modulo 10^9 + 7
        long[] pow10 = new long[m + 1];
        pow10[0] = 1;
        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % mod;
        }

        // Prefix arrays (1-indexed to easily handle L-1 == -1)
        long[] prefVal = new long[m + 1];
        int[] prefCount = new int[m + 1];
        long[] prefSum = new long[m + 1];

        for (int i = 0; i < m; i++) {
            int digit = s.charAt(i) - '0';
            
            // If it's a non-zero digit, shift the previous value and add it
            if (digit > 0) {
                prefVal[i + 1] = (prefVal[i] * 10 + digit) % mod;
                prefCount[i + 1] = prefCount[i] + 1;
            } else {
                prefVal[i + 1] = prefVal[i];
                prefCount[i + 1] = prefCount[i];
            }
            
            // Standard prefix sum includes all digits (0s don't affect sum)
            prefSum[i + 1] = prefSum[i] + digit;
        }

        int q = queries.length;
        int[] answer = new int[q];

        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];


            int nonZeroDigits = prefCount[r+1] - prefCount[l];
            int R = r+1, L = l;

            // 2. Extract the concatenated value x using the rolling hash formula
            // We add 'mod' before taking the remainder to prevent negative results in Java
            long x = (prefVal[R] - (prefVal[L] * pow10[nonZeroDigits]) % mod + mod) % mod;

            // 3. Get the sum of digits in the range
            long sum = prefSum[R] - prefSum[L];

            // 4. Compute the final answer for the query
            answer[i] = (int) ((x * sum) % mod);
        }

        return answer;
    }
}






















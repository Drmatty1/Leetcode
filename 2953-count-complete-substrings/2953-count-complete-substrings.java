class Solution {
    int count( char[]arr, int s, int e, int k, int u){
        if( e-s+1 < k*u ) return 0;
        
        int res = 0;
        int count = 0;  // count_elem_with_freq_equal_k_in_window

        int[] map = new int[26];

        for(int i=s; i<=e; i++){

            int c = arr[i]-'a';
            map[c] ++;

            if( map[c] == k ) count++;
            if( count == u ) res++;

            if( i-s+1 >= k*u ){
                int prev = arr[i-k*u+1]-'a';
                map[prev] --;
                if( map[prev] == k-1 ) count--;
            }

        }

        return res;

    }
    public int countCompleteSubstrings(String word, int k) {
        int i = 0, j = 1, n = word.length();

        char []arr = word.toCharArray();
        int ans = 0;

        while( j <= n ){
            
            // No Break-Point
            if( j < n && Math.abs(arr[j]-arr[j-1]) <= 2 ){
                j++;
            }
            else{
                for(int u=1; u<=26; u++){
                    ans += count(arr, i, j-1, k, u);
                }
                i = j;
                j++;
            }
        }
        return ans;
    }        
}
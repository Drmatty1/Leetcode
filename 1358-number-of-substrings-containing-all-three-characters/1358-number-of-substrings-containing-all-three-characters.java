class Solution {
    public int numberOfSubstrings(String s) {

        // Map<Character,Integer> map = new HashMap<>();
        int []map = new int[3];
        int size = 0;

        int n = s.length();
        char []arr = s.toCharArray();
        int i = 0, j =0;
        int ans = 0;
        while( j <= n ) {
            if( size == 3 ) {
                ans += n-j+1;
                char toRem = arr[i];
                map[toRem-'a'] -- ;
                if( map[toRem-'a'] == 0 ) size--;
                i++;
            }
            else if( j < n ) {
                char c = arr[j];
                map[c-'a']++;
                if( map[c-'a'] == 1 ) size++;
                j++;
            }
            else{
                break;
            }

        }

        return ans;
    }
}
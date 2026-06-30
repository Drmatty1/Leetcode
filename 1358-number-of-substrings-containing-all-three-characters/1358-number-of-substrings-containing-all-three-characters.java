class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length();
        char []arr = s.toCharArray();
        int i = 0, j =0;
        int ans = 0;
        while( j <= n ) {
            if( map.size() == 3 ) {
                ans += n-j+1;
                char toRem = arr[i];
                map.put(toRem, map.get(toRem)-1);
                if( map.get(toRem) == 0 ) map.remove(toRem);
                i++;
            }
            else if( j < n ) {
                char c = arr[j];
                map.put(c, map.getOrDefault(c,0)+1);
                j++;
            }
            else{
                break;
            }

        }

        return ans;
    }
}
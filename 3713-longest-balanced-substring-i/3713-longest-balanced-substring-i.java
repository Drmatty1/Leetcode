class Solution {
    int findmin(int []arr){
        int min = 1000;
        for( int I : arr ){
            if( I != 0 && I < min ) min = I;
        }
        return min;
    }
    public int longestBalanced(String s) {

        int n = s.length();
        int ans = 0;

        for( int i=0; i<n; i++ ){

            if( ans >= n-i ) break; //early exit

            int []map = new int[26];
            int max = 0  ;
            int uniq = 0;

            for( int j=i; j<n; j++ ){
                
                char c = s.charAt(j);
                map[c-'a']++;

                if( map[c-'a'] == 1 ) uniq++;
                max = Math.max(max,map[c-'a']);

                if( max*uniq == j-i+1 ) ans = Math.max(ans,j-i+1);

            }
        }
        return ans;
    }
}
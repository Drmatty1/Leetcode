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

            int []map = new int[26];
            int max = 0 ,min = n ;

            for( int j=i; j<n; j++ ){
                char c = s.charAt(j);
                map[c-'a']++;
                min = findmin(map);
                max = Math.max(max,map[c-'a']);
                if( min == max ) ans = Math.max(ans,j-i+1);
            }
        }
        return ans;
    }
}
class Solution {
    int solve( String s, String target ){
        
        int []freq = new int[26];
        for( char c : s.toCharArray() ) freq[c-'a']++;

        int []tfreq = new int[26];
        for( char c : target.toCharArray() ) tfreq[c-'a']++;

        int min = 10000;
        for( char c : target.toCharArray() ){
            min = Math.min( min, freq[c-'a']/tfreq[c-'a'] );
        }

        return min;

    }
    public int maxNumberOfBalloons(String text) {
        return solve( text, "balloon" );
    }
}
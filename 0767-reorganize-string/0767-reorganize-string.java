class Solution {
    public String reorganizeString(String s) {
        int []map = new int[26];
        PriorityQueue<Character> pq = new PriorityQueue<>((c1,c2)->{
            return Integer.compare(map[c2-'a'],map[c1-'a']);
        });
        char []arr = s.toCharArray();
        for( char c : arr ) map[c-'a']++;
        for( int i=0; i<26; i++  ){
            if( map[i] != 0 )
                pq.add((char)(i+'a'));
        }

        
        StringBuilder ans = new StringBuilder() ;
        while( !pq.isEmpty() ){

            ArrayList<Character> temp = new ArrayList<>();
            int window = 2;
            while( window!=0 && !pq.isEmpty() ){
                char c = pq.poll();
                window--;
                map[c-'a']--;
                ans.append(c);
                if( map[c-'a'] > 0 ) temp.add(c);
            }

            
            if( window != 0 && !temp.isEmpty() ) return "";
            for( char c : temp ) pq.add(c);

        }

        return new String(ans);

    }
}
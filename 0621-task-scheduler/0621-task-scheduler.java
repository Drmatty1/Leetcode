class Solution {
   
    public int leastInterval(char[] tasks, int n) {
        
        int []map = new int[26];
        for( char c : tasks ) map[c-'A']++;

        PriorityQueue<Character> pq = new PriorityQueue<> ( 
            (c1,c2)->{
            return Integer.compare( map[c2-'A'],map[c1-'A'] );
        } );

        for( int i=0; i<26; i++ ){
            if( map[i] != 0 )
                pq.add((char)(i+'A'));
        }

        int ans=0;   //interval

        while( !pq.isEmpty() ){
            List<Character> temp = new ArrayList<>();
            int window = n+1;
            while( window>0 && !pq.isEmpty() ){
                char c = pq.poll();
                ans++;
                window--;
                map[c-'A']--;
                if( map[c-'A'] > 0 ){
                    temp.add(c);
                }
            }
    
            for( char c : temp ) pq.add(c);
            if( window != 0 && temp.size()!=0 ) ans+= window;
        
        }
        return ans;
    }
}
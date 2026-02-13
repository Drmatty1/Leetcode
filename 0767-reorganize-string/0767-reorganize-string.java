class Solution {
    public String reorganizeString(String s) {
        int []map = new int[128];
        PriorityQueue<Character> pq = new PriorityQueue<>((c1,c2)->{
            return Integer.compare(map[c2],map[c1]);
        });

        // char []arr = s.toCharArray();
        for( char c : s.toCharArray() ) map[c]++;
        for( int i=0; i<128; i++  ){
            if( map[i] != 0 )
                pq.add((char)(i));
        }

        StringBuilder ans = new StringBuilder() ;
        char prev = '$'; 
        int n = s.length();

        while( !pq.isEmpty() ){

            // ArrayList<Character> temp = new ArrayList<>();
            char c = pq.poll();
            map[c]--;
            ans.append(c);

            if( map[prev] > 0 ) pq.add(prev);

            prev = c;
        }

        return ans.length()==n? (new String(ans)):"" ;

    }
}
//   without temp array
/**
class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] arr = new int[26];

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        // Check if any character occurs more than (n+1)/2
        int maxAllowed = (n + 1) / 2;
        for (int freq : arr) {
            if (freq > maxAllowed) return "";
        }

        // Max-heap based on frequency
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) pq.offer(new Pair((char) (i + 'a'), arr[i]));
        }

        StringBuilder sb = new StringBuilder();
        Pair prev = new Pair('#', 0);

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            sb.append(curr.c);
            curr.freq--;

            // Push previous character back into heap if it still has frequency
            if (prev.freq > 0) {
                pq.offer(prev);
            }

            prev = curr; // update prev outside the if
        }

        return sb.length() == n ? sb.toString() : "";
    }
}

// Pair class to store character and frequency
class Pair {
    char c;
    int freq;

    public Pair(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }
}
 */
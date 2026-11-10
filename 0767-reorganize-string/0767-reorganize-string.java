class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];  
        int maxCount = 0;
        int n = s.length();

        for (char task : s.toCharArray()) {
            freq[task - 'a']++;
            maxCount = Math.max(maxCount, freq[task - 'a']);
        }

        if(maxCount*2-1 > n) return "";

        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> freq[b]-freq[a]
        );
        for(int i=0; i<26; i++){
            if(freq[i]>0)  pq.add(i);
        }

        char []res = new char[n];
        int k=0;
        int prev = -1;
        while(!pq.isEmpty()){
            int c = pq.poll();
            res[k++] = (char)(c+'a');

            if(prev != -1) {
                pq.add(prev);
                prev = -1;
            }

            freq[c]--;
            if(freq[c]>0) prev = c;

        }

        return new String(res);

    }
}
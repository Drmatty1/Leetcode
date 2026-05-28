class Solution {
    class Trie{
        int []tuple ;
        Trie []next ;
        Trie(){
            next = new Trie[26];
            tuple = new int[]{5001,10000};
        }
        Trie( int [] a){
            next = new Trie[26];
            tuple = a;
        }

    }

    void add(Trie curr, String s, int j, int i){
        if(j < 0 )return ;

        char c = s.charAt(j);

        if(curr.next[c-'a'] == null){
            Trie next = new Trie(new int[]{ s.length(), i});
            curr.next[c-'a'] = next;
            add(next, s, j-1, i);
        }
        else{
            Trie next = curr.next[c-'a'];
            int []a = next.tuple;
            int []b = new int[]{ s.length(), i};
            
            if( a[0] > b[0] || (a[1] > b[1] && a[0]==b[0]) ) {
                curr.next[c-'a'].tuple = b;
            }
            add(next, s, j-1, i);
        }

    }

    int find(Trie curr, String s, int j, int min ){
        
        char c = 'z';
        if( j>=0 ) c = s.charAt(j);

        if( j < 0 || curr.next[c-'a'] == null ){
            int idx = curr.tuple[1];
            return (idx!=10000?idx:min);
        }
        else{
            return find(curr.next[c-'a'], s, j-1, min);
        }

    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        
        Trie root = new Trie();
        int minVal = 100000;
        int min = -1;

        int i=0;
        for(String s: wordsContainer){
            int j = s.length()-1;
            add(root, s, j, i);
            if( j+1 < minVal ){
                minVal = j+1;
                min = i;
            }
            i++;
        }

        i=0;
        int []ans = new int[wordsQuery.length];
        for(String s: wordsQuery){
            int j = s.length()-1;
            ans[i] = find(root, s, j, min);
            i++;
        }

        return ans;

    }
}
//(#1.m, #2.l, #3.i) -> d:(1, 4, 0) 
                     // d:(1, 3, 1)
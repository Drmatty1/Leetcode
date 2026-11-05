class Solution {
    class Node {
        Node[] children = new Node[26];
        boolean isEnd = false;
    }
    class Trie {

        Node root = new Node();

        // Insert word
        public void insert(String word) {
            Node curr = root;

            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';

                if (curr.children[idx] == null) {
                    curr.children[idx] = new Node();
                }

                curr = curr.children[idx];
            }

            curr.isEnd = true;
        }

    }
    boolean dfs(String s, int i, Trie t){
        int n = s.length();
        Node curr = t.root;

        for(int j=i; j<n; j++){
            char c = s.charAt(j);
            curr = curr.children[c-'a'];
        
            if(curr == null) return false;
            if(curr.isEnd){
                boolean res = dfs(s,j+1,t);
                if(res) return true;
            }
        }
        return curr.isEnd;
    }

    Boolean []dp;
    boolean dfsDP(String s, int i, Trie t){
        int n = s.length();
        if(i==s.length()) return true;
        Node curr = t.root;

        if(dp[i] != null) return dp[i];

        for(int j=i; j<n; j++){
            char c = s.charAt(j);
            curr = curr.children[c-'a'];
        
            if(curr == null) return dp[i] = false;
            if(curr.isEnd){
                boolean res = dfsDP(s,j+1,t);
                if(res) return dp[i] =  true;
            }
        }
        return dp[i] = curr.isEnd;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie t = new Trie();
        for(String st: wordDict) t.insert(st);
        Node curr = t.root;

        // return dfs(s,0,t);

        dp = new Boolean[s.length()];
        return dfsDP(s,0,t);
    }
}
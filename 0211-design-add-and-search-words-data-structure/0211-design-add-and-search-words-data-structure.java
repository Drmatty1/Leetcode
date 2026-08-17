class WordDictionary {
    Set<String> set;

    public WordDictionary() {
        set = new HashSet<>();
    }
    
    public void addWord(String word) {
        set.add(word);
    }
    
    public boolean search(String word) {
        int i=-1,j=-1;
        int n = word.length();
        for(int k=0; k<n; k++){
            char c = word.charAt(k);
            if(c=='.'){
                if(i<0) i = k;
                else{ 
                    j=k;
                    break;
                }
            }
        }

        StringBuilder temp = new StringBuilder(word);

        if(i>=0 && j>=0){
            for(int p=0; p<26; p++){
                char old1 = temp.charAt(i);
                temp.setCharAt(i,(char)(p+'a'));
                for(int q=0; q<26; q++){
                    char old2 = temp.charAt(j);
                    temp.setCharAt(j,(char)(q+'a'));
                    // System.out.println(temp);
                    if(set.contains(temp.toString())) return true;
                    temp.setCharAt(j,old2);
                }
                temp.setCharAt(i,old1);
            }
        }
        if(i>=0){
            for(int p=0; p<26; p++){
                char old1 = temp.charAt(i);
                temp.setCharAt(i,(char)(p+'a'));
                if(set.contains(temp.toString())) return true;
                temp.setCharAt(i,old1);
            }
        }
        else {
            if(set.contains(temp.toString())) return true;
        }
      
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
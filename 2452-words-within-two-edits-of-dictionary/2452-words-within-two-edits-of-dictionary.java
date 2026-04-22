class Solution {
    int hm(String a, String b){
        int mm = 0;
        if( a.length() != b.length() ) return 3; //>2
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)!=b.charAt(i)) mm++;
            if(mm>2)return mm; // pruning
        }
        return mm;
    }
    public List<String> twoEditWords(String[] queries, String[]dictionary ) {
        // Set<String> set = new HashSet<>();
        // for(String s:dictionary) set.add(s);
        List<String> res = new ArrayList<>();

        for( String s: queries ){
            // if( set.contains(s) )res.add(s);
            // else {
                for( String t: dictionary ){
                    if(hm(s,t)<=2){
                        res.add(s);
                        break;
                    }
                }
            // }
        }
        return res;
    }
}
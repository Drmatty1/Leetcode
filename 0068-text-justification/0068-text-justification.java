class Solution {
    String sol(String[] words, int max, int i, int j){
        
        int chars = 0;
        for(int t=i; t<=j; t++){
            chars += words[t].length();
        }

        int gaps = j-i;             // ==0 ????

        if( j == words.length-1 || gaps == 0 ){

            StringBuilder res = new StringBuilder(max);
            int rem = max - gaps-chars ;

            for(int t=i; t<j; t++){
                res.append(words[t]).append(" ");
            }
            res.append(words[j]);

            while(rem -->0){
                res.append(" ");
            }
            return new String(res);
        }

        int spaces = max - chars;
        int pergaps = spaces/gaps;
        int extra = spaces%gaps;

        StringBuilder res = new StringBuilder(max);

        for(int t=i; t<j; t++){
            res.append(words[t]);
            int temp = pergaps + (extra>0?1:0) ;
            extra -- ;
            while(temp -->0){
                res.append(" ");
            }
        }
        res.append(words[j]);

        return new String(res);

    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        
        int i=0;
        int n = words.length;
        
        while( i<n ){
            int j=i;
            int len = words[j].length();
            while(j+1<n){
                if(len+1+words[j+1].length() <= maxWidth ){
                    j++;
                    len += 1+words[j].length();
                }
                else break;
            }
            ans.add(sol(words, maxWidth, i, j));
            i = j+1;
        }
        return ans;
    }
}
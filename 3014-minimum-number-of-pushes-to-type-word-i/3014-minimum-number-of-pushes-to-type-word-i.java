class Solution {
    public int minimumPushes(String word) {
        int [][]f = new int[26][2];
        char []arr = word.toCharArray();

        for(char c: arr){
             f[c-'a'][0] ++;
             f[c-'a'][1] = c-'a';
        }

        Arrays.sort(f,(a,b)->Integer.compare(b[0],a[0]));

     
        int []revMap = new int[26];
        int r = 1;
        for(int j=0; j<26; j++){
            if(f[j][0] == 0) continue;
            
            revMap[f[j][1]] = r++;   // r rep  rank
        }

    
        int push = 0;
        for(char c: arr){
            int rank = revMap[c-'a'];
            if(rank<=8) push+=1;
            else if(rank<=16) push+=2;
            else if(rank <=24) push+=3;
            else push +=4;
        }

        return push;
        
    }
};
class Solution {
    public int minimumPushes(String word) {
        int []f = new int[26];
        char []arr = word.toCharArray();

        for(char c: arr){
             f[c-'a'] ++;
        }

        Arrays.sort(f);

        int push = 0;
        int rank = 1;
        for(int j=25; j>=0; j--){
            int freq = f[j];
            if(freq == 0)continue;
            if(rank<=8) push+=1*freq;
            else if(rank<=16) push+=2*freq;
            else if(rank <=24) push+=3*freq;
            else push +=4*freq;
            rank++;
        }

        return push;
        
    }
};
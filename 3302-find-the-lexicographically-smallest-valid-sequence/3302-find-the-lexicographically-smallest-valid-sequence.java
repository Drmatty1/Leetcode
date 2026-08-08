class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length(), m = word2.length();

        // from word2 pov
        int []suff = new int[m+1];
        suff[m] = n;
        int j = m-1;
        for(int i=n-1; i>=0 && j>=0; i--){
            if(word1.charAt(i) == word2.charAt(j)){
                suff[j] = i;
                j--;
            }
        }

        j = 0;
        int []ans = new int[m];
        int k = 0;

        boolean changed = false;
        for(int i=0; i<n && j<m; i++){
            if(word1.charAt(i) == word2.charAt(j)){
                ans[k++] = i;
                j++;
            }
            else if(changed==false && suff[j+1] > i ){
                ans[k++] = i;
                j++;
                changed = true;
            }
        }

        if(j==m) return ans;
        return new int[]{};
    }
}
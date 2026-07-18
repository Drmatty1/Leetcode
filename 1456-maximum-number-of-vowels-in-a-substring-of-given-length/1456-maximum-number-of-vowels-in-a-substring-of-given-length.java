class Solution {
    int []arr = {'a','e','i','o','u'};
    int count(int []f){
        int c = 0;
        for(int e: arr) {
            c+=f[e];
        }
        System.out.println();
        return c;
    }
    public int maxVowels(String s, int k) {
        int []f = new int[128];
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            f[c] ++;
            if( i >= k ){
                f[s.charAt(i-k)] --;
            }
            ans = Math.max(ans,count(f));
        }
        return ans;
    }
}
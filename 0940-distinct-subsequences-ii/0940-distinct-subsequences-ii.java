class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;

        int []endWith = new int[26];
        int total=0;

        for(char c: s.toCharArray()){
            int idx = c-'a';

            int added = (total+1-endWith[idx]+mod)%mod;
            endWith[idx] = (total+1)%mod;

            total = (total+added)%mod;
        }

        return total;
    }
}
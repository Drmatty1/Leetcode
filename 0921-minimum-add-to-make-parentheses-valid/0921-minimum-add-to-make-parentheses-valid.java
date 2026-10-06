class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0;
        int bal=0;
        for(char c: s.toCharArray()){
            if(c=='(') bal++;
            else bal--;

            if(bal < 0){ ans -= bal; bal=0;}
        }
        return ans+bal;
    }
}
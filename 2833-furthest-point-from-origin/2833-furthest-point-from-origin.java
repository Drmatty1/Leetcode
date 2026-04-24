class Solution {
    int sol(String s){

        int r = 0, l = 0;
        for(char c: s.toCharArray()){
            if(c == 'R')r++;
            if(c == 'L')l++;
        }

        int d = s.length()-r-l;
        if(l > r) return l+d-r;
        return r+d-l;

    }
    public int furthestDistanceFromOrigin(String moves) {
        return sol(moves) ;
    }
}
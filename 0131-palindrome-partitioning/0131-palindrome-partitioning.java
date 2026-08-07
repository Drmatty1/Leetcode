class Solution {
    List<List<String>> ans;
    boolean check(String s, int i, int j){
        while(i<=j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    //extra optimization
    boolean [][]dp;

    void sol(int i, String s, List<String> temp){
        if(i>=s.length()){
            ans.add(new ArrayList<>(temp));
        }
        for(int j=i; j<s.length(); j++){
            if(dp[i][j]) {
                temp.add(s.substring(i,j+1));
                sol(j+1,s,temp);
                temp.remove(temp.size()-1);
            }
        }

    }
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        
        dp = new boolean[s.length()][s.length()];
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<s.length(); j++){
                dp[i][j] = check(s,i,j);
            }
        }

        List<String> temp = new ArrayList<>();
        sol(0,s,temp);
        return ans;
    }
}
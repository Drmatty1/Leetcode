class Solution {
    void solve( int l, int r, int n, StringBuilder t, List<String>ans ){
    
        if( r == n ){ 
            ans.add(new String(t));
            return;
        }
        if( l<n ){
            t.append("(");
            solve(l+1,r,n,t,ans);
            t.delete(t.length() - 1, t.length());
        }
        if( r<l ){
            t.append(")");
            solve(l,r+1,n,t,ans);
            t.delete(t.length() - 1, t.length());
        }
        
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder t = new StringBuilder();
        solve(0,0,n,t, ans);
        return ans;
    }
}
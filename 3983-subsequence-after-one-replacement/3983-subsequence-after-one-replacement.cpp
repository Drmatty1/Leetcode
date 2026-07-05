class Solution {
public:
    int n,m;
    unordered_map<int,unordered_map<int,unordered_map<int,int>>> dp;
    bool f(int i,int j,int c,string& s, string& t){
        if(i==n) return true;
        if(j==m) return false;
        
        bool ans=false;
        if(dp.find(i)!=dp.end() && dp[i].find(j)!=dp[i].end() && 
         dp[i][j].find(c)!=dp[i][j].end() ) return dp[i][j][c];

        if(m-j<n-i) return false;
        if(s[i]==t[j]){
                ans=ans|f(i+1,j+1,c,s,t);
            }
        else if(c==1){
                ans=ans|f(i+1,j+1,0,s,t)|f(i,j+1,c,s,t);
            }
        else{
                ans=ans|f(i,j+1,c,s,t);
            }
        return dp[i][j][c]=ans;
    }
    
    bool canMakeSubsequence(string s, string t) {
        unordered_map<char,int> mpp;
        n=s.size();
        m=t.size();
        
        
        bool b=f(0,0,1,s,t);
    
        return b;
    }
};
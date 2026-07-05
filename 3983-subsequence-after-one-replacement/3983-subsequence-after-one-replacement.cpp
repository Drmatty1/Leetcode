class Solution {
public:
    int n,m;
    unordered_map<string,int> dp;
    bool f(int i,int j,int c,string& s, string& t){
        if(i==n) return true;
        if(j==m) return false;
        
        bool ans=false;
        string key = to_string(i) + "-" + to_string(j) + "-" + to_string(c);

        if(dp.find(key)!=dp.end() ) return dp[key];

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
        return dp[key]=ans;
    }
    
    bool canMakeSubsequence(string s, string t) {

        n=s.size();
        m=t.size();
    
        bool b=f(0,0,1,s,t);
    
        return b;
    }
};
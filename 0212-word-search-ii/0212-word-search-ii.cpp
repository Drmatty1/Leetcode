class Solution {
public:
    bool dfsOP( int i, int j, int t, vector<vector<char>>& a, string &word ){
        int r = a.size(), c= a[0].size() ;
        if( i >= r || i<0 || j>=c || j<0  ){
            return 0;
        }
        if( t == word.size()-1 && word[t] == a[i][j] ) return 1;
        
        // vs[((i)<<4)|j]=1;   // works only up to 16x16 grids
        // vs[i * 100 + j] = 1;  // works safely up to 100x100 grids
        char temp = a[i][j];
        a[i][j] = '$' ;            // works for every no. of grid

        bool ri=0,l=0,u=0,d=0;
        if( i+1 < r && word[t+1] == a[i+1][j]  ){
            d=dfsOP( i+1,j,t+1,a,word );
        }
        if( d == 1 ){
            a[i][j] = temp ;
            return 1;
        }
    
        if( j+1 < c  && word[t+1] == a[i][j+1] ){
            ri=dfsOP( i,j+1,t+1,a,word );
        }
        if( ri == 1 ){
            a[i][j] = temp ;
            return 1;
        }

        if( i-1>=0  &&  word[t+1] == a[i-1][j] ){
            u=dfsOP( i-1,j,t+1,a,word );
        }
        if( u == 1 ){
            a[i][j] = temp ;
            return 1;
        }

        if( j-1 >=0  && word[t+1] == a[i][j-1] ){
            l=dfsOP( i,j-1,t+1,a,word );
        }
        if( l == 1 ){
            a[i][j] = temp ;
            return 1;
        }

        a[i][j] = temp ;
        return 0;

    }

    
    bool exist(vector<vector<char>>& board, string word) {
        int r = board.size(),c= board[0].size() ;
        unordered_map<int,bool>vs;
        vector<vector<int>> vis(r, vector<int>(c, 0));

        for( int i=0;i<r;i++ ){
            for(int j=0; j<c; j++){
                if( word[0] == board[i][j] ){
                    // bool ans = dfs( i, j, 0, board, word ,vs );  // 368ms
                    // bool ans = dfs1( i, j, 0, board, word ,vis );   //159ms
                    bool ans = dfsOP( i, j, 0, board, word ); // 131ms
                    if( ans == 1 ) return 1;
                }
            }
        }
        return 0;
    }
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        vector<string> ans;
        for( auto &s:words ){
            int n = s.length();
            int *freq = new int[26];
            for(int i=0; i<26; i++) freq[i]= 0;
            for(char c: s){
                freq[c-'a'] ++;
            }
            bool isRev = false;
            if(freq[s[n-1]-'a'] < freq[s[0]-'a']){
                reverse(s.begin(), s.end());
                isRev = true;
            }
            delete[] freq;
            if( exist(board,s) ){
                if(isRev == true) reverse(s.begin(), s.end());
                ans.push_back(s);
            }
        }
        return ans;
    }
};
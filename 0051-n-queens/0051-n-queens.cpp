class Solution {
public:
        
    void put ( vector< vector<int> > &v , int x ,int y ,int n ){
        
        for(int i = 0 ; i< n ;i ++){
        
            for( int j=0 ; j< n ;j++){
                
                if(i==x || j == y){
                v[i][j] ++ ;
                }
                
            }

        }
        
        v[x][y] -= 4 ;
        
        for (int i = 0; i < n; ++i) {
        
            if (x + i < n && y + i < n) {
                v[x + i][y + i] += 1;  // diagonal from top-left to bottom-right
            }
            if (x - i >= 0 && y - i >= 0) {
                v[x - i][y - i] += 1;  // diagonal from bottom-right to top-left
            }
            if (x + i < n && y - i >=0 ) {
                v[x + i][y - i] += 1;  // diagonal from top-left to bottom-right
            }
            if (x - i >= 0 && y + i <n ) {
                v[x - i][y + i] += 1;  // diagonal from bottom-right to top-left
            }
        }
        
    }

    void putback ( vector< vector<int> > &v , int x ,int y ,int n ){
        
        for(int i = 0 ; i< n ;i ++){
        
            for( int j=0 ; j< n ;j++){
                
                if(i==x || j == y){
                v[i][j] -- ;
                }
                
            }

        }
        
        v[x][y] += 4 ;
        
        for (int i = 0; i < n; ++i) {
        
            if (x + i < n && y + i < n) {
                v[x + i][y + i] -= 1;  // diagonal from top-left to bottom-right
            }
            if (x - i >= 0 && y - i >= 0) {
                v[x - i][y - i] -= 1;  // diagonal from bottom-right to top-left
            }
            if (x + i < n && y - i >=0 ) {
                v[x + i][y - i] -= 1;  // diagonal from top-left to bottom-right
            }
            if (x - i >= 0 && y + i <n ) {
                v[x - i][y + i] -= 1;  // diagonal from bottom-right to top-left
            }
        }
        
    }

        
    void NQueenO ( vector< vector<int> > &v , int n ,vector<string> &temp,  vector<vector<string>> &ans, int y){
    
        //base case
        if( y==n ){
            ans.push_back(temp);
        //   printch (ans , n);
        // exit(0);
        return;
        }
        
        
        for(int i = 0 ; i< n ;i ++){

                // string s ( n, "." );
                
                if( v[i][y] == 0 ){
                
                    put( v, i, y, n );
                
                    // ans[i][y] = "Q";
                    // s[y] = "Q";
                    temp[i][y] = 'Q';
                    
                    NQueenO ( v, n ,temp, ans, y+1);
                    
                    // ans[i][y] = "." ;
                    // s[y] = ".";
                    temp[i][y] = '.';
                
                    putback( v, i, y, n );
                
                }
                
                
            // }

        }
    
    }


    vector<vector<string>> solveNQueens(int n) {
        vector <vector<int> > v( n , vector<int>(n,0) );
        vector <vector<string> > ans; 
        vector<string> temp(n, string(n,'.'));

        NQueenO ( v, n,temp, ans, 0 );
        return ans;
    }
};
class Solution {
    public String[] createGrid(int m, int n, int k) {
        
        if( (m==1||n==1) && k>1 ) return new String[0];
        
        char[][] res = new char[m][n];
        for(int i=0; i<m; i++) Arrays.fill(res[i],'#');
        
        if( m==1 || n==1 ){
            for(int i=0; i<m; i++) Arrays.fill(res[i],'.');
        }
        else if( m >= 3 && n>=3 ){
            
            for(int i=0; i<m; i++) res[i][n-1]='.' ;
            for(int i=0; i<n; i++) res[0][i]='.' ;
            
            if(k==4 && n == 3){
                res[0][n-1] = '#';
                for(int i=0; i<n; i++) res[1][i]='.' ;
                for(int i=1; i<n; i++) res[2][i]='.' ;
            }
            else{
                for(int j = n-1; j>=n-k  ; j--){
                    res[1][j] = '.';
                }
            }
        }
        else if( m >= 3 ){  // n==2
        
            if( k > 3 && m == 3 ) return new String[0];

            res[0][0] = '.';
            for(int i=0; i<m; i++) res[i][1]='.' ;
            
            for(int i = 1; i<k ; i++){
                res[i][0] = '.';
            }
        }
        else if( n >= 3 ){   // m==2
            
            if( k > 3 && n == 3 ) return new String[0];
            
            for(int i=0; i<n; i++) res[0][i]='.' ;
            
            for(int j = n-1; j>=n-k ; j--){
                res[1][j] = '.';
            }
            
        }
        else{  // m==n==2
            if( k > 2 ) return new String[0];
            else{
                for(int i=0; i<m; i++) Arrays.fill(res[i],'.');
                if( k == 1 ){
                    res[1][0] = '#';
                }
            }
        }

        String[] ans = new String[m];
        for(int i=0; i<m; i++) ans[i] = new String(res[i]);
        return ans;
    }
}
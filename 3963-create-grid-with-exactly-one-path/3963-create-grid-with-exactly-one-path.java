class Solution {
    public String[] createGrid(int m, int n) {
        char [][]arr = new char[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = '#';
            }
        }

        for(int i=0; i<m; i++) arr[i][0] = '.';
        for(int j=0; j<n; j++) arr[m-1][j] = '.';

        String[]ans = new String[m];
        for(int i=0; i<m; i++) ans[i] = new String(arr[i]);

        return ans;
    }
}
class Solution {
    int countR(int[]arr){
        int count=0;
        for( int I:arr ) count+=I;
        return count;
    }
    int countC(int [][]mat,int j){
        int r  = mat.length;
        int count= 0 ;
        for( int i=0; i<r; i++ ) count+=mat[i][j];
        return count; 
    }
    public int numSpecial(int[][] mat) {
        int ans =0 ;
        int r=mat.length, c = mat[0].length;
        for( int i=0 ; i<r; i++){
            if( countR(mat[i])==1 ){
                int j=0;
                while(mat[i][j]!=1)j++;
                if(countC(mat,j)==1) ans+=1;
            }
        }
        return ans;
    }
}
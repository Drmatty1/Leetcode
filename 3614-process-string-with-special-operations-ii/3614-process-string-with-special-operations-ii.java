class Solution {

    public char processStr(String s, long k) {
        
        char[]arr = s.toCharArray();
        int n = arr.length;

        long size = 0;

        for(int i=0; i<n; i++){
            char c = arr[i];
            if(c =='*'){
                if(size != 0) size--;
            }
            else if( c=='#' ){
                size *= 2;
            }
            else if( c == '%' ){
                // null
            }
            else{
                size++;
            }
        }

        if(k >= size) return '.';
    
        for(int i = n-1; i>=0 ; i--){

            char c = arr[i];

            if(c =='*'){
                if(size == 0) continue ;
                size ++;
            }
            else if( c=='#' ){
                if(size == 0) continue ;

                size /= 2;
                if( k >= size) k = k-size;
            }
            else if( c == '%' ){
                k = size-k-1;
            }
            else{
                if( k == size-1 ) return c;
                else{
                    if(size != 0) size --;
                }
            }
        }

        return '.';

    }
}
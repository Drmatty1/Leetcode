class Solution {
    int countTrailingZeros(int[]arr){
        int count=0;
        for( int i=arr.length-1; i>=0; i-- ){
            if( arr[i] != 0 ) break;
            count++;
        }
        return count;
    }
    int find(int[]arr, int tar, int s){
        for( ; s<arr.length ; s++){
            if(arr[s]>=tar) return s;
        }
        return -1;
    }
    public int minSwaps(int[][] grid) {
        int r = grid.length;
        int []check = new int[r];
        
        for( int i = 0; i<r; i++ ){
            int c = countTrailingZeros(grid[i]);
            check[i] = c;
        }
        
        int ans=0;
        for( int i=0; i<r; i++ ){
            if( check[i] < r-1-i ){
                int idx = find(check,r-1-i,i+1);
                if( idx == -1 )return -1;
                int temp = check[i];
                check[i] = check[idx];
                int t = i+1;
                while( t<r && t<=idx ){
                    int a = temp;
                    temp = check[t];
                    check[t] = a;
                    t++;
                    ans++;
                }
            }
        }
        return ans;

    }
}
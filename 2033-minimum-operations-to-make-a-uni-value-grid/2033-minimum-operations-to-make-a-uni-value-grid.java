class Solution {
    void swap(int[]a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    int partition(int []a, int l, int r){
        int pivot = a[r];
        int i = l;
        for(int j=l; j<r; j++){
            if(a[j] <= pivot){
                swap(a,i,j);
                i++;
            }
        }
        swap(a,i,r);
        return i;
    }
    int quickSelect(int []a, int l, int r, int k){

        while( l<= r){

            int partition = partition(a,l,r);

            if(partition == k) return a[k];

            if( partition > k){
                r = partition -1;
            }
            else{
                l = partition +1;
            }
        }

        return -1 ;

    }

    public int minOperations(int[][] grid, int x) {
        
        int m = grid.length, n = grid[0].length;
        int size = m * n;

        int[] arr = new int[size];
        int k = 0;

        int rem = grid[0][0] % x;

        // flatten + check
        for (int[] row : grid) {
            for (int val : row) {
                if (val % x != rem) return -1;
                arr[k++] = val;
            }
        }

        // find median using quickselect
        int median = quickSelect(arr, 0, size - 1, size / 2);

        // count operations
        int ops = 0;
        for (int val : arr) {
            ops += Math.abs(val - median) / x;
        }

        return ops;

    }
}
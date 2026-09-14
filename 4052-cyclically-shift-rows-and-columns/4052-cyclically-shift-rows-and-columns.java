class Solution {
    void print(int [][]grid){
        int n = grid.length;
        for(int []e: grid){
            for(int a: e){
                System.out.print(a+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    void row(int []arr, int k){

        int n = arr.length;
        int []a = new int[n];
        k = k%n;

        for(int j=0; j<n; j++){
            a[(j-k+n)%n] = arr[j];
        }

        for(int j=0; j<n; j++){
            arr[j]= a[j];
        }

    }
    void col(int [][]arr, int c, int k){

        int n = arr.length;
        int []a = new int[n];
        k = k%n;

        for(int j=0; j<n; j++){
            a[(j-k+n)%n] = arr[j][c];
        }

        for(int j=0; j<n; j++){
            arr[j][c] = a[j];
        }

    }

    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {

        int i=0;
        for(int e: rowShift){
            row(grid[i++],e);
            // print(grid);
        }

        int j=0;
        for(int e: colShift){
            col(grid,j++,e);
            // print(grid);
        }

        return grid;
    }
}
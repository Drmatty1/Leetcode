class Solution {
    int find(char[] arr, int idx, char t) {
        for (int i = arr.length - 1; i >= idx; i--) {
            if (arr[i] > t)
                return i;
        }
        return -1;
    }

    void swap(char[] arr, int a, int b) {
        char t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    void reverse(char[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    void nextPerm(char[] arr){
        int l = arr.length - 1;
        for (int i = l; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                int idx = find(arr, i, arr[i - 1]);
                swap(arr, i - 1, idx);
                reverse(arr, i, arr.length - 1);
                break;
            }
        }
    }

    String sol1(int n, int k) {
        char[] arr = new char[n];
        for (int i = 0; i < n; i++)
            arr[i] = (char) (i + '1');

        while (k-- > 1) {
            nextPerm(arr);
        }
        return new String(arr);
    }

    public String getPermutation(int n, int k) {
        char[] arr = new char[n];
        for(int i=0; i<n; i++) arr[i] = (char)(i+'1');

        int[] f = new int[n+1];
        f[0] = 1;
        for(int i=1; i<=n; i++) f[i] = i*f[i-1];
        
        for(int i=0; i<n; i++){
            int rem = n-i-1;
            int fact = f[rem];
            int t = k/fact;
            if( k%fact == 0 ) t--;
            if( fact < k ){
                for(int j = i+t; j>i; j-- ){
                    swap(arr, j, j-1);
                }
                k -= fact*t;
            }
        }

        return new String(arr);
    }
}
class Solution {
    int find(char[]arr , int idx, char t){
        for(int i=arr.length-1; i>=idx; i--){
            if(arr[i] > t) return i;
        }
        return -1;
    }
    void swap(char[]arr, int a, int b){
        char t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
    void reverse(char[] arr, int i, int j){
        while(i<j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }

    void nextPerm( char[] arr ){
        int l = arr.length-1;
        for(int i=l; i>0; i--){
            if(arr[i] > arr[i-1]){
                int idx = find(arr, i, arr[i-1]);
                swap(arr, i-1, idx);
                reverse(arr, i, arr.length-1);
                break;
            }
        }
    }
    public String getPermutation(int n, int k) {
        char[] arr = new char[n];
        for(int i=0; i<n; i++) arr[i] = (char)(i+'1');
        
        while(k-->1){
            nextPerm(arr);
        }
        return new String(arr);
    }
}
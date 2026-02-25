class Solution {
    void swapArr(int []arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    int partition(int []arr, int s, int e){
        int i = s-1, j = s, pivot = arr[e];
        while( j < e){
            int a = bitCount(arr[j]), b = bitCount(pivot);
            if( a < b || (a==b && arr[j]<pivot)) swapArr(arr,++i,j);
            j++;
        }
        swapArr(arr, i+1, e);
        return i+1;
    }
    void QS(int []arr, int s, int e){
        if(s>e) return ;
        int pivot = partition(arr,s,e);
        QS(arr, s, pivot-1);
        QS(arr, pivot+1, e);
    }
    int bitCount(int a){
        int count = 0;
        while(a>0){
            count += (a&1)==1?1:0;
            a = a>>1;
        }
        return count;
    }

    public int[] sortByBits(int[] arr) {
        QS(arr,0,arr.length-1);
        System.out.println(bitCount(116));
        return arr;
    }
}
class Solution {
    int bs(long []arr, long t){
        int i=0, j = arr.length-1;
        int ps = -1;
        while(i<=j){
            int mid = (j-i)/2+i;
            if(arr[mid] <= t){
                ps = mid;
                i = mid+1;
            }
            else{
                j = mid-1;
            }
        }
        return ps;
    }
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length, m = shifts.length;
        long []pre = new long[n+1];
        for(int i=0; i<n; i++){
            pre[i+1] = pre[i]+tasks[i];
        }

        int []ans= new int[m];
        long carry = 0;
        for(int j=0; j<m; j++){
            int idx = bs(pre,shifts[j]+carry);
            ans[j] = n-idx;
            if(ans[j] != 0){
                carry += shifts[j];
            }
            else carry = 0;
        }
        return ans;
    }
}

// 0 1 2 5 14 24, n = 5
// 8: 5-3=2, carry = 5+3 = 8
// 10+8: 5-4=1 

// 0 4 6
// 3: 3-0=3, carry = 0 + 3 = 3
// 6+3: 3-3=0, carry = 0
// 1: 3-0=3, carry = 0+ 1 = 1

// 1 5 9
// initailly carry = 0,
// find elem e<=(9+carry) in p-arr

// 0 2 5 9 
// 20: 0, carry=0
// 4: 3-1=2, carry=2
// 5: 3-2=1














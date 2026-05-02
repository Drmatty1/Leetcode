class Solution {
    void swap(int []a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    void print(int[]nums){
        for(int e:nums)System.out.print(e+" ");
        System.out.println();

    }
    void reverse(int []a, int s, int e){
        int i = s;
        int j = e;
        while(i<j){
            while( i<=e && a[i] < 0 ) i++;
            while( j>i && a[j] < 0 ) j--;
            if(i<j){
                swap(a,i,j);
                i++; j--;
            }
        }
    }
    public int[] rotateElements(int[] nums, int k) {
        
        int l = 0, n = nums.length;
        for(int e:nums) l+= (e>=0?1:0);

        if(l==0 || k==0) 
            return nums; //nothing to rotate

        reverse(nums,0,n-1);
        // print(nums);
        
        k = k%l;
        k = l-k;

        int t=0;
        for(int i=0; i<n; i++){
            t += (nums[i]>=0?1:0);
            if(t==k){
                reverse(nums,0,i);
                // print(nums);
                reverse(nums,i+1,n-1);
                // print(nums);
                break;
            }
        }

        return nums;

    }
}
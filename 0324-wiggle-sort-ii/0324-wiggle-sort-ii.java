class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int mid = (n+1)/2;
        int i = 0, j = 1;
        int []ans = new int[n+2];
        
        int p = mid-1;;
        while(p>=0 && i < n ){
            ans[i] = nums[p--];
            i+=2;
        }

        int q = n-1;
        while(q>=mid && j < n){
            // System.out.println(ans[j]+" "+j+" "+nums[q]+" "+q);
            ans[j] = nums[q--];
            j+=2;
        }

        for(int t=0; t<n; t++) nums[t] = ans[t];

        return ;
    }
}
// 1 1 1   4 5 6
// 1 4 1 5 1 6

// 1 1 2   2 3 3 
// 1 2 1 3 2 3

// 1 2 2   3 3
// 1 3 2 3 2

// 4 5   5 6
// 4 5 5 6   - X
// 5 6 4 5  best

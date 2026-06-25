class Solution {
    int []count;

    void countAndMerge(int []indices, int[] arr, int l, int m, int r) {
      
        int n1 = m - l + 1, n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++)
            left[i] = indices[i + l];
        for (int j = 0; j < n2; j++)
            right[j] = indices[m + 1 + j];

       
        int rightCount = 0;
        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {

            if (arr[left[i]] <= arr[right[j]]){
                count[left[i]] += rightCount;
                indices[k++] = left[i++];
            }
            else {
                rightCount++;
                indices[k++] = right[j++];
            }

        }

        // Merge remaining elements
        while (i < n1){
            count[left[i]] += rightCount;
            indices[k++] = left[i++];
        }
        while (j < n2){
            indices[k++] = right[j++];
        }

    }
    void countInv(int []indices, int[] arr, int l, int r) {

        if (l < r) {
            int m = (r - l) / 2 + l;
            countInv(indices, arr, l, m);
            countInv(indices, arr, m + 1, r);
            countAndMerge(indices, arr, l, m, r);
        }
       
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int []indices = new int [n];
        for(int i=0; i<n; i++) indices[i] = i;

        count = new int[n];

        countInv(indices, nums, 0, n-1);

        List<Integer> ans = new ArrayList<>();
        for(int e: count) ans.add(e);
        
        // return ans;
        return new java.util.AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return count[index];
            }
            @Override
            public int size() {
                return count.length;
            }
        };
    }
}
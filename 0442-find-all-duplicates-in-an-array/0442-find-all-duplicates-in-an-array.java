class Solution {
    void swap(int[]arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    int[] sortArray(int arr[]) {
        int n = arr.length;
        int i=0;
        while( i<n ){
            if( arr[i]-1 != i ){
                swap(arr,i,arr[i]-1);
                if( arr[i] == arr[arr[i]-1] ){
                    i++;
                }
            }
            else{
                i++;
            }
        }
        return arr;
    }
    public List<Integer> findDuplicates(int[] nums) {
        sortArray(nums);
        List<Integer> ans = new ArrayList<>();
        for( int i=0; i<nums.length; i++ ){
            if( nums[i]-1 != i && nums[i] > 0 ){
                ans.add(nums[i]);
                nums[nums[i]-1] *= -1;
            }
            // System.out.println(nums[i]);
        }
        return ans;
    }
}
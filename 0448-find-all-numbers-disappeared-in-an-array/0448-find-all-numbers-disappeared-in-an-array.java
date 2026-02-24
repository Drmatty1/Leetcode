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
            if( arr[i] != arr[arr[i]-1] ){
                swap(arr,i,arr[i]-1);
            }
            else{
                i++;
            }
        }
        return arr;
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        sortArray(nums);
        List<Integer> ans = new ArrayList<>();
        for( int i=0; i<nums.length; i++ ){
            if( nums[i]-1 != i ){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
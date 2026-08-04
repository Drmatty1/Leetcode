class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        int max = 1, min = 100;
        for(int e: nums){
            max = Math.max(max, e);
            min = Math.min(min, e);
        }

        int []freq = new int[max+1];
        for(int e: nums) freq[e]++;

        List<Integer> ans = new ArrayList<>();
        for(int i=min; i<=max; i++){
            if(freq[i]==0) ans.add(i);
        }
        
        return ans;
    }
}
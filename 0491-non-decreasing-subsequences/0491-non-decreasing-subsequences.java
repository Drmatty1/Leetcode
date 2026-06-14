class Solution {
    void sol(int []nums, int idx, int prev, List<Integer> temp, Set<List<Integer>> res ){
        if(idx == nums.length){
            if(temp.size()>1)res.add(new ArrayList<>(temp));
            return ;
        }

        if( nums[idx] >= prev ){
            temp.add(nums[idx]);
            sol(nums, idx+1, nums[idx], temp, res);
            temp.remove(temp.size()-1);
        }

        sol(nums, idx+1, prev, temp, res);

    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        sol(nums, 0, -100,  new ArrayList<>(), res);
        return new ArrayList<>(res);
    }
}
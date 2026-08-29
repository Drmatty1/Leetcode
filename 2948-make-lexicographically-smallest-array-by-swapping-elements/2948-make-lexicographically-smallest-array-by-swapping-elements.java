class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        
        int []sortedArr = nums.clone();
        Arrays.sort(sortedArr);

        Map<Integer,Integer> grpNo = new HashMap<>();
        Map<Integer,Deque<Integer>> grp = new HashMap<>();
        int group = 0;

        grpNo.put(sortedArr[0],group);
        grp.computeIfAbsent(group, k-> new ArrayDeque<>()).addLast(sortedArr[0]);

        for(int i=1; i<nums.length; i++){

            if(sortedArr[i] - sortedArr[i-1] > limit){
                group++;
            }

            grpNo.put(sortedArr[i],group);
            grp.computeIfAbsent(group, k-> new ArrayDeque<>()).addLast(sortedArr[i]);

        }

        for(int i=0; i<nums.length; i++){
            int currGrp = grpNo.get(nums[i]);
            nums[i] = grp.get(currGrp).pollFirst();
        }

        return nums;

    }
}






























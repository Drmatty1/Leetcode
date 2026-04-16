class Solution {
    int find( List<Integer>arr, int c, int n ){

        int idx = Collections.binarySearch(arr,c);
        int l = arr.size();
        
        int leftIdx = (idx - 1 + l) % l;
        int rightIdx = (idx+1) % l;

        int leftDist = Math.abs(c - arr.get(leftIdx));
        int rightDist = Math.abs(arr.get(rightIdx) - c);

        int leftMin = Math.min(leftDist,n-leftDist);
        int rightMin = Math.min(rightDist,n-rightDist);

        return Math.min(leftMin, rightMin);
        
    }
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for( int i=0; i<n; i++ ){
            int key=nums[i];
            if( !map.containsKey(key) ){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(i);
        }

        List<Integer> ans = new ArrayList<>();
        for( int q: queries ){

            if( map.get(nums[q]).size()==1 )ans.add(-1);
            else{
                int near = find(map.get(nums[q]),q,n);
                ans.add(near);
            }

        }

        return ans;

    }
}